package midianet.sisvend.financeiro.repository;

import midianet.sisvend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido,String> {
    List<Pedido> findByRecebidoIsTrue();
}
