package callbus.homework.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articleId")
    private Article article;

    private Long memberId;

    @Builder
    public Heart(Long id, Article article, Long memberId) {
        this.id = id;
        this.article = article;
        this.memberId = memberId;
    }
}
