package qwuerty.backend.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qwuerty.backend.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
    User findUserByUsername(String username);

}
