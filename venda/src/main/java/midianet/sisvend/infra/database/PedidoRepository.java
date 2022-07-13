package midianet.sisvend.infra.database;

import midianet.sisvend.core.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,String> {

}
