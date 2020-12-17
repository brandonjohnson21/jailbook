package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends CrudRepository<Post, Integer>, JpaSpecificationExecutor<Post> {

}