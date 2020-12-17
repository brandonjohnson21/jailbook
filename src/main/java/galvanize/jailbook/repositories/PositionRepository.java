package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PositionRepository extends CrudRepository<Position, Integer>, JpaSpecificationExecutor<Position> {

}