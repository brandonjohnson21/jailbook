package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.CriminalPosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CriminalPositionRepository extends CrudRepository<CriminalPosition, Integer>, JpaSpecificationExecutor<CriminalPosition> {

}