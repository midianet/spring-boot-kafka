package midianet.sisvend.estoque;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.stream.Collectors;

@Slf4j
@Component
public class PedidoConsumer {

    @KafkaListener(topics = "${pedidos.topico}", groupId = "${spring.kafka.consumer.pedido.group-id}")
    public void consumer(Pedido pedido) {
        log.info(String.format("Pedido recebido [%s], reservando os produtos:\n  %s",
            pedido.getId(),
            pedido.getItens()
                .stream()
                .map(item -> String.format("  %s [%s]", item.getProduto(), item.getQuantidade()))
                .collect(Collectors.joining("\n")))
        );
    }

}
