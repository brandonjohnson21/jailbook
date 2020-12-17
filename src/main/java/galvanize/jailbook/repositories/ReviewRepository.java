package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReviewRepository extends CrudRepository<Review, Integer>, JpaSpecificationExecutor<Review> {

}