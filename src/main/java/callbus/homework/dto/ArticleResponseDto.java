package callbus.homework.dto;

import callbus.homework.domain.MemberType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticleResponseDto {
    private String title;
    private Integer heartCount;
    private Boolean isHeart;
    private MemberType account_type;
}
