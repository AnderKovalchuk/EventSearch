package EventSearch.repositories;

//import java.util.List;
import org.springframework.data.repository.CrudRepository;

import EventSearch.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
  User findByLogin(String login);
  User findByEmail(String email);
}
