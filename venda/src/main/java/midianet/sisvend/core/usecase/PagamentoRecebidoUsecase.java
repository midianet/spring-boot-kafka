package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoRecebidoUsecase {
    private final PedidoRepository repository;

    @Transactional
    public void execute(final Pagamento pagamento){
        repository.findById(pagamento.getPedido())
            .ifPresent(pedido -> {
                pedido.setStatus(Pedido.Status.RECEBIDO);
                repository.save(pedido);
                log.info("\n [Módulo de Vendas]\n Alterando o Status do Pedido: {}\n Status: {}",
                        pedido.getId(),
                        pedido.getStatus().toString());
        });
    }

}