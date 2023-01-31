package callbus.homework.repository;

import callbus.homework.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart,Long> {
}
