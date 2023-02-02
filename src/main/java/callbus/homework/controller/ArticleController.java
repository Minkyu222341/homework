package callbus.homework.controller;

import callbus.homework.dto.ArticleRequestDto;
import callbus.homework.dto.ArticleResponseDto;
import callbus.homework.service.ArticleService;
import callbus.homework.service.HeartService;
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
        String authentication = servletRequest.getHeader("Authentication");
        return articleService.getAllArticles(authentication);
    }

    @PostMapping
    public ResponseEntity<String> postArticle(HttpServletRequest servletRequest,
                                              @RequestBody ArticleRequestDto requestDto) {
        String authentication = servletRequest.getHeader("Authentication");
        return articleService.postArticle(authentication, requestDto);
    }




}
