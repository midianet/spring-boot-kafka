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
    private final PedidoRepository pedidoRepository;
    private final EnviarPedidoUsecase enviarPedido;

    @Transactional
    public void execute(final Pagamento pagamento){
        pedidoRepository.findById(pagamento.getPedido())
            .ifPresent(pedido -> {
                pedido.setStatus(Pedido.Status.ENVIADO);
                enviarPedido.execute(pedido);
                pedidoRepository.save(pedido);
                log.info("\n [Módulo Estoque]\n Pagamento Recebido do Pedido: {}, Liberando para Envio",pedido.getId());
        });
    }

}