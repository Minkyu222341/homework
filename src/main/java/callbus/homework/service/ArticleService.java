package callbus.homework.service;

import callbus.homework.domain.Article;
import callbus.homework.domain.Heart;
import callbus.homework.dto.ArticleRequestDto;
import callbus.homework.dto.ArticleResponseDto;
import callbus.homework.repository.ArticleRepository;
import callbus.homework.repository.HeartRepository;
import callbus.homework.util.MemberTypeCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final HeartRepository heartRepository;
    private final MemberTypeCheck memberTypeCheck;
    public ResponseEntity<List<ArticleResponseDto>> getAllArticle(String userInfo) {
        Long loginMemberId = memberTypeCheck.memberIdCheck(userInfo);
            List<ArticleResponseDto> articleList = getArticleList(loginMemberId);
        return ResponseEntity.ok().body(articleList);
    }


    private List<ArticleResponseDto> getArticleList(Long loginMemberId) {
        List<Article> getAllArticle = articleRepository.findAll();
        List<ArticleResponseDto> articleList = new ArrayList<ArticleResponseDto>();
        for (Article article : getAllArticle) {
            articleList.add(ArticleResponseDto.builder()
                    .title(article.getTitle())
                    .heartCount(article.getHeartList().size())
                    .account_type(article.getMember().getAccount_type())
                    .isHeart(isCheckHeart(loginMemberId, article))
                    .build());
        }
        return articleList;
    }

    private boolean isCheckHeart(Long loginMemberId, Article article) {
        boolean checkHeart = heartRepository.existsByArticleAndMemberId(article, loginMemberId);
        return checkHeart;
    }
}
