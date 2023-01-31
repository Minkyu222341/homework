package callbus.homework.repository;

import callbus.homework.domain.Lessee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LesseeRepository extends JpaRepository<Lessee,Long> {
}
