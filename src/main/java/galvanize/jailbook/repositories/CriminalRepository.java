package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CriminalRepository extends JpaRepository<Criminal, Integer>, JpaSpecificationExecutor<Criminal> {

}