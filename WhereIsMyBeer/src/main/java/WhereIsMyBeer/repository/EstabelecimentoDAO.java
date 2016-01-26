package WhereIsMyBeer.repository;

import WhereIsMyBeer.model.Estabelecimento;
import WhereIsMyBeer.service.EstabelecimentoService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by micdomingues on 23/12/2015.
 */
public interface EstabelecimentoDAO extends CrudRepository<Estabelecimento, Long>, EstabelecimentoService {
}
