package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Heist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistRepository extends CrudRepository<Heist, Integer>, JpaSpecificationExecutor<Heist> {

}