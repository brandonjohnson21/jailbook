package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.HeistPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistPositionRepository extends JpaRepository<HeistPosition, Integer>, JpaSpecificationExecutor<HeistPosition> {

}