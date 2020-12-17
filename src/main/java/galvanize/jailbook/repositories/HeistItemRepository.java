package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.HeistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistItemRepository extends JpaRepository<HeistItem, Integer>, JpaSpecificationExecutor<HeistItem> {

}