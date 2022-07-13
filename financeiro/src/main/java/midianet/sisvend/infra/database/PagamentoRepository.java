package midianet.sisvend.infra.database;

import midianet.sisvend.core.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,String> {

}