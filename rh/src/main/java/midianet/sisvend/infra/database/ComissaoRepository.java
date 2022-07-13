package midianet.sisvend.infra.database;

import midianet.sisvend.core.entity.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComissaoRepository extends JpaRepository<Comissao,String> {

}