package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.HeistItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistItemRepository extends CrudRepository<HeistItem, Integer>, JpaSpecificationExecutor<HeistItem> {

}