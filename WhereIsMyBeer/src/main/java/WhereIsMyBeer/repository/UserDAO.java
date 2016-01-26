package WhereIsMyBeer.repository;

import WhereIsMyBeer.model.User;
import WhereIsMyBeer.service.UserService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by micdomingues on 23/12/2015.
 */
public interface UserDAO extends CrudRepository<User, Long>, UserService {

    User findByUsername(String username);
}
