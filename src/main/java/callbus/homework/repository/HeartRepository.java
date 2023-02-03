package callbus.homework.repository;

import callbus.homework.domain.Article;
import callbus.homework.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeartRepository extends JpaRepository<Heart,Long> {
    boolean existsByArticleAndMemberId(Article article, Long memberId);

    List<Heart> findAllByOrderByIdDesc();
}
