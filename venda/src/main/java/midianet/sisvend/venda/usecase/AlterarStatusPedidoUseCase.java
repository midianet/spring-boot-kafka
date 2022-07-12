package midianet.sisvend.venda.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.PedidoStatus;
import midianet.sisvend.venda.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarStatusPedidoUseCase {
    private final PedidoRepository repository;

    @Transactional
    public void execute(final PedidoStatus status){
        repository.findById(status.getId())
            .ifPresent(pedido -> {
                pedido.setStatus(status.getStatus());
                repository.save(pedido);
                log.info("\n [Módulo de Vendas]\n Mudança de Status do Pedido: {}\nStatus: {}",
                        pedido.getId(),
                        pedido.getStatus());
        });
    }

}