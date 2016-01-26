package WhereIsMyBeer.repository;

import WhereIsMyBeer.model.Estabelecimento;
import WhereIsMyBeer.model.FixedDomains.Cidade;
import WhereIsMyBeer.service.CidadeService;
import WhereIsMyBeer.service.EstabelecimentoService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by micdomingues on 23/12/2015.
 */
public interface CidadeRepository extends CrudRepository<Cidade, Long>, CidadeService {
}
