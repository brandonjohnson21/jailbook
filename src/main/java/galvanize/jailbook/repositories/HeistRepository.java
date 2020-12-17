package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.Heist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistRepository extends JpaRepository<Heist, Integer>, JpaSpecificationExecutor<Heist> {

}