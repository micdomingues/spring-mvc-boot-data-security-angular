package WhereIsMyBeer.repository;

import WhereIsMyBeer.model.Estabelecimento;
import WhereIsMyBeer.model.User;
import WhereIsMyBeer.service.service.EstabelecimentoService;
import WhereIsMyBeer.service.service.UserService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by micdomingues on 23/12/2015.
 */
public interface EstabelecimentoDAO extends CrudRepository<Estabelecimento, Long>, EstabelecimentoService {
}
