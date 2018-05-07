package task.repository;

import org.springframework.data.repository.CrudRepository;
import task.model.User;

/**
 * @author Pavel Smokorovskiy on 03.05.18
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);
    void deleteById(long id);
}
