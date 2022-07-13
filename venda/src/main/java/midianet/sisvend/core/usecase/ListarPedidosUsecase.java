package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPedidosUsecase {

    private final PedidoRepository repository;

    public List<Pedido> execute(){
        return repository.findAll();
    }

}
