package galvanize.jailbook.repositories;

import galvanize.jailbook.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MessageRepository extends CrudRepository<Message, Integer>, JpaSpecificationExecutor<Message> {

}