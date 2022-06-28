package midianet.sisvend.financeiro.broker;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Component
public class PedidoConsumer {

    @KafkaListener(topics = "${pedidos.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(Pedido pedido) {
        log.info("\n [Módulo Financeiro]\n Pedido recebido: {}\n Viabilizando o pagamento do cliente: {}\n Valor: {}",
            pedido.getId(),
            pedido.getCliente(),
            pedido.getValor());
    }
}
