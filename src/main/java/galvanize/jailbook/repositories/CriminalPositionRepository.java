package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.CriminalPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CriminalPositionRepository extends JpaRepository<CriminalPosition, Integer>, JpaSpecificationExecutor<CriminalPosition> {

}