package callbus.homework.controller;

import callbus.homework.dto.HeartResponseDto;
import callbus.homework.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeartController {
    private final HeartService heartService;

    @GetMapping("/heart")
    public ResponseEntity<List<HeartResponseDto>> getHeartHistory() {
        return heartService.getHeartHistory();
    }

    @PostMapping("/article/heart/{articleId}")
    public ResponseEntity<String> addHeart(@PathVariable Long articleId, HttpServletRequest servletRequest) {
        String memberInfo = servletRequest.getHeader("Authentication");
        return heartService.addHeart(articleId,memberInfo);
    }
}
