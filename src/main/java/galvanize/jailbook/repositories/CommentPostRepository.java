package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.CommentPost;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CommentPostRepository extends CrudRepository<CommentPost, Integer>, JpaSpecificationExecutor<CommentPost> {

}