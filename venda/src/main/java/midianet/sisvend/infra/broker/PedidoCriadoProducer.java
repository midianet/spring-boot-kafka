package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoCriadoProducer {

    @Value("${topico.pedido.novo}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final Pedido pedido) {
        kafkaTemplate.send(topico, pedido);
    }

}