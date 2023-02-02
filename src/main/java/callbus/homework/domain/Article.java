package callbus.homework.domain;

import callbus.homework.util.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Heart> heartList = new ArrayList<>();

    @Builder
    public Article(Long id, String title, Boolean deleted, Member member, List<Heart> heartList) {
        this.id = id;
        this.title = title;
        this.deleted = deleted;
        this.member = member;
        this.heartList = heartList;
    }
}
