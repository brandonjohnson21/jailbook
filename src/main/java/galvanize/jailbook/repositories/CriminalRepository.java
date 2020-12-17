package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Criminal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CriminalRepository extends CrudRepository<Criminal, Integer>, JpaSpecificationExecutor<Criminal> {

}