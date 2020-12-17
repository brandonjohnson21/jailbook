package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FriendsRepository extends JpaRepository<Friends, Integer>, JpaSpecificationExecutor<Friends> {

}