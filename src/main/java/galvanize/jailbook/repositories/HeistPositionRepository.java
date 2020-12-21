package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Heist;
import galvanize.jailbook.entities.HeistPosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistPositionRepository extends CrudRepository<HeistPosition, Integer>, JpaSpecificationExecutor<HeistPosition> {

    Iterable<HeistPosition> findAllByHeistId(int i);

    Iterable<HeistPosition> findAllByCriminalId(int i);


}