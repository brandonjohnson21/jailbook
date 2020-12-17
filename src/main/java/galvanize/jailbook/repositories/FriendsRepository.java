package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FriendsRepository extends CrudRepository<Friends, Integer>, JpaSpecificationExecutor<Friends> {

}