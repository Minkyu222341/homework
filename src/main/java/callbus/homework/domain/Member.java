package callbus.homework.domain;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    @Enumerated(EnumType.STRING)
    private MemberType account_type;

    private Boolean quit;


    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Article> articleList;

    @Builder
    public Member(Long id, String nickname, MemberType account_type, Boolean quit, List<Article> articleList) {
        this.id = id;
        this.nickname = nickname;
        this.account_type = account_type;
        this.quit = quit;
        this.articleList = articleList;
    }
}
