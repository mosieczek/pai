package qwuerty.backend.repos;

import org.springframework.data.repository.CrudRepository;
import qwuerty.backend.models.Fridge;
import qwuerty.backend.models.User;

import java.util.List;

public interface FridgeRepository extends CrudRepository<Fridge, Long> {
    List<Fridge> getAllByUser(User user);
    Fridge findFridgeById(Long id);
}
