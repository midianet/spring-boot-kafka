package midianet.sisvend.venda.usecase;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.model.Pedido;
import midianet.sisvend.venda.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPedidoUseCase {

    private final PedidoRepository repository;

    public List<Pedido> execute(){
        return repository.findAll();
    }

}
