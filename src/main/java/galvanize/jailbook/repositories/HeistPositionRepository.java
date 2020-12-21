package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.HeistPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface HeistPositionRepository extends CrudRepository<HeistPosition, Integer>, JpaSpecificationExecutor<HeistPosition> {

}