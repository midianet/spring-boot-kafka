package midianet.sisvend.financeiro;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Component
public class PedidoConsumer {

    @KafkaListener(topics = "${pedidos.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(Pedido pedido) {
        log.info(String.format("Pedido recebido [%s], viabilizando o pagamento para o cliente %s, no valor de %s",
            pedido.getId(),
            pedido.getCliente(),
            pedido.getValor())
        );
    }
}
