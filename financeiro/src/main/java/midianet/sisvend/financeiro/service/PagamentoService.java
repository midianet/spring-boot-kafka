package midianet.sisvend.financeiro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.financeiro.broker.PagamentoProducer;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoProducer producer;
    private final PedidoService pedidoService;
    public void receber(@NonNull final String pedidoId){
        final var pedido = pedidoService.findById(pedidoId);
        log.info("\n [Módulo Financeiro]\n Pagamento recebido\n Pedido: {}\n Cliente: {}\n Valor: {}",
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValor());
        producer.send(pedido);

    }
}
