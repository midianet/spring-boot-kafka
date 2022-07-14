package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.broker.PagamentoRecebidoProducer;
import midianet.sisvend.infra.database.PagamentoRepository;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceberPagamentoUsecase {

    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final PagamentoRecebidoProducer pagamentoRecebidoProducer;

    @Transactional
    public void execute(@NonNull final String pedidoId) {
        final var pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        pedido.setStatus(Pedido.Status.RECEBIDO);
        pedidoRepository.save(pedido);
        final var pagamento = pagamentoRepository.save(Pagamento.builder()
                        .data(LocalDateTime.now())
                        .valor(pedido.getValor())
                        .vendedor(pedido.getVendedor())
                        .pedido(pedido.getId()).build());
        pagamentoRecebidoProducer.send(pagamento);
        log.info("\n [Módulo Financeiro]\n Pagamento recebido\n Pedido: {}\n Cliente: {}\n Valor: {}",
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValor());
    }

}