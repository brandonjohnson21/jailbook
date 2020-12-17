package galvanize.jailbook.repositories;

import com.example.demo.profile.entities.CommentPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentPostRepository extends JpaRepository<CommentPost, Integer>, JpaSpecificationExecutor<CommentPost> {

}