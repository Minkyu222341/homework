package callbus.homework.controller;

import callbus.homework.dto.ArticleRequestDto;
import callbus.homework.dto.ArticleResponseDto;
import callbus.homework.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getAllArticles(HttpServletRequest servletRequest) {
        String memberInfo = servletRequest.getHeader("Authentication");
        return articleService.getAllArticles(memberInfo);
    }

    @PostMapping
    public ResponseEntity<String> postArticle(HttpServletRequest servletRequest,
                                              @RequestBody ArticleRequestDto requestDto) {
        String memberInfo = servletRequest.getHeader("Authentication");
        return articleService.postArticle(memberInfo, requestDto);
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity<String> updateArticle(HttpServletRequest servletRequest,
                                                            @PathVariable Long articleId,
                                                            @RequestBody ArticleRequestDto requestDto) {
        String memberInfo = servletRequest.getHeader("Authentication");
        return articleService.updateArticle(memberInfo,articleId,requestDto);
    }

    @DeleteMapping("{articleId}")
    public ResponseEntity<String> deleteArticle(HttpServletRequest servletRequest,
                                                @PathVariable Long articleId) {
        String memberInfo = servletRequest.getHeader("Authentication");
        return articleService.delete(memberInfo,articleId);
    }
}
