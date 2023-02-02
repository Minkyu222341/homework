package callbus.homework.service;

import callbus.homework.domain.Article;
import callbus.homework.domain.Heart;
import callbus.homework.domain.Member;
import callbus.homework.domain.MemberType;
import callbus.homework.dto.ArticleRequestDto;
import callbus.homework.dto.ArticleResponseDto;
import callbus.homework.msg.Msg;
import callbus.homework.repository.ArticleRepository;
import callbus.homework.repository.HeartRepository;
import callbus.homework.repository.MemberRepository;
import callbus.homework.util.MemberTypeCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final HeartRepository heartRepository;
    private final MemberRepository memberRepository;
    private final MemberTypeCheck memberTypeCheck;


    public ResponseEntity<List<ArticleResponseDto>> getAllArticles(String memberInfo) {
        Long loginMemberId = memberTypeCheck.memberIdCheck(memberInfo);
        List<ArticleResponseDto> articleList = memberIdCheckAndArticlesLookUp(loginMemberId);
        return ResponseEntity.ok().body(articleList);
    }

    public ResponseEntity<String> postArticle(String userInfo, ArticleRequestDto requestDto) {
        String memberType = memberTypeCheck.accountTypeCheck(userInfo);
        return memberTypeCheckAndSaveArticle(userInfo, requestDto, memberType);
    }



    private List<ArticleResponseDto> memberIdCheckAndArticlesLookUp(Long loginMemberId) {
        List<Article> getAllArticle = articleRepository.findAll();
        List<ArticleResponseDto> articleList = new ArrayList<>();
        for (Article article : getAllArticle) {
            articleList.add(ArticleResponseDto.builder()
                    .title(article.getTitle())
                    .heartCount(article.getHeartList().size())
                    .memberNicknameAndType(getMemberNicknameAndType(article))
                    .isHeart(isCheckHeart(loginMemberId, article))
                    .build());
        }
        return articleList;
    }

    private String getMemberNicknameAndType(Article article) {
        String accountType = "";
        if (article.getMember().getAccount_type() == MemberType.REALTOR) {
            accountType = "공인중개사";
        } else if (article.getMember().getAccount_type() == MemberType.LESSOR) {
            accountType = "임대인";
        } else if (article.getMember().getAccount_type() == MemberType.LESSEE) {
            accountType = "임차인";
        }
        return article.getMember().getNickname() + "(" + accountType + ")";
    }

    private boolean isCheckHeart(Long loginMemberId, Article article) {
        return heartRepository.existsByArticleAndMemberId(article, loginMemberId);
    }
    private ResponseEntity<String> memberTypeCheckAndSaveArticle(String userInfo, ArticleRequestDto requestDto, String memberType) {
        if (memberType.equals("ANONYMOUS")) {
            return ResponseEntity.badRequest().body(Msg.ACCESS_DENIED.getMsg());
        } else {
            Long loginMemberId = memberTypeCheck.memberIdCheck(userInfo);
            Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new IllegalArgumentException(Msg.UNKNOWN_MEMBER.getMsg()));
            Article article = Article.builder().title(requestDto.getTitle())
                    .member(loginMember)
                    .deleted(false)
                    .build();
            articleRepository.save(article);
            return ResponseEntity.ok().body(Msg.WRITE_SUCCESS.getMsg());
        }
    }



}
