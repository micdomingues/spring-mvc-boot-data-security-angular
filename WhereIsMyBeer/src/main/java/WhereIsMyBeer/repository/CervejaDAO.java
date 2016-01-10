package WhereIsMyBeer.repository;

import WhereIsMyBeer.model.Estabelecimento;
import WhereIsMyBeer.service.service.CervejaService;
import WhereIsMyBeer.service.service.EstabelecimentoService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by micdomingues on 23/12/2015.
 */
public interface CervejaDAO extends CrudRepository<Estabelecimento, Long>, CervejaService {
}
