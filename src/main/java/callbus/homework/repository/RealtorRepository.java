package callbus.homework.repository;

import callbus.homework.domain.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealtorRepository extends JpaRepository<Realtor,Long> {
}
