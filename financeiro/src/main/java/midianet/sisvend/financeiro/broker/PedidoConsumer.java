package midianet.sisvend.financeiro.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.financeiro.service.PedidoService;
import midianet.sisvend.model.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoConsumer {

    private final PedidoService service;
    @KafkaListener(topics = "${pedidos.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final Pedido pedido) {
        pedido.setStatus("Aguardando Pagamento");
        service.salvar(pedido);
        log.info("\n [Módulo Financeiro]\n Pedido recebido: {}\n Viabilizando o pagamento do cliente: {}\n Valor: {}",
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValor());
    }
}
