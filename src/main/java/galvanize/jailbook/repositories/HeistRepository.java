package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Heist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HeistRepository extends CrudRepository<Heist, Integer>, JpaSpecificationExecutor<Heist> {

    Heist findByHeistId(int i);

    Iterable<Heist> findAllByHeistDescriptionContaining(String desc);

    Iterable<Heist> findAllByLocationContaining(String desc);

    Iterable<Heist> findAllByScoreContaining(String desc);

    Iterable<Heist> findAllByTargetContaining(String desc);

    Iterable<Heist> findAllByTitleContaining(String desc);

    Iterable<Heist> findAllByMastermind(int i);


}