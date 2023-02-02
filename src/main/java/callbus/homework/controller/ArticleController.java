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
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article")
    public ResponseEntity<List<ArticleResponseDto>> getArticleList(HttpServletRequest servletRequest) {
        String authentication = servletRequest.getHeader("Authentication");
        return articleService.getAllArticle(authentication);
    }

//    @PostMapping("/article")
//    public ResponseEntity<String> postArticle(@RequestHeader("Authorization") String userType,
//                                              @RequestBody ArticleRequestDto requestDto) {
//        return articleService.postArticle(userType,requestDto);
//    }


}
