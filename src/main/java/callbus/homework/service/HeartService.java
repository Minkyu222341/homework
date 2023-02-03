package callbus.homework.service;

import callbus.homework.domain.Article;
import callbus.homework.domain.Heart;
import callbus.homework.domain.Member;
import callbus.homework.dto.HeartResponseDto;
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
public class HeartService {
    private final ArticleRepository articleRepository;
    private final HeartRepository heartRepository;
    private final MemberRepository memberRepository;
    private final MemberTypeCheck memberTypeCheck;


    public ResponseEntity<String> addHeart(Long articleId, String memberInfo) {
        Long loginMemberId = memberTypeCheck.memberIdCheck(memberInfo);
        return heartStatusCheck(loginMemberId, articleId);
    }

    public ResponseEntity<List<HeartResponseDto>> getHeartHistory() {
        List<Heart> heartList = heartRepository.findAllByOrderByIdDesc();
        ArrayList<HeartResponseDto> histories = new ArrayList<>();
        for (Heart heart : heartList) {
            String recode = getRecode(heart);
            histories.add(HeartResponseDto.builder().history(recode).build());
        }
        return ResponseEntity.ok().body(histories);
    }

    private ResponseEntity<String> heartStatusCheck(Long loginMemberId, Long articleId) {
        Article article = articleRepository.findById(articleId).
                orElseThrow(() -> new IllegalArgumentException(Msg.UNKNOWN_ARTICLE.getMsg()));
        boolean isChecked = heartRepository.existsByArticleAndMemberId(article, loginMemberId);
        if (!isChecked) {
            Heart heart = Heart.builder().
                    article(article).
                    memberId(loginMemberId).
                    build();
            heartRepository.save(heart);
            return ResponseEntity.ok().body(Msg.HEART_SUCCESS.getMsg());
        } else {
            return ResponseEntity.ok().body(Msg.ALREADY_HEART.getMsg());
        }
    }

    private String getRecode(Heart heart) {
        Article article = heart.getArticle();
        Long memberId = heart.getMemberId();
        Member member = memberRepository.findById(memberId).
                orElseThrow(() -> new IllegalArgumentException(Msg.UNKNOWN_MEMBER.getMsg()));
        return member.getNickname() + " 님이 " + article.getId() + " 번째 게시글을 추천했습니다.";
    }

}
