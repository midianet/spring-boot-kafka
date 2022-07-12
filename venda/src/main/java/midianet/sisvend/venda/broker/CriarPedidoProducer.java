package midianet.sisvend.venda.broker;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.model.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@RequiredArgsConstructor
public class CriarPedidoProducer {

    @Value("${pedido.topico}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final @RequestBody Pedido pedido) {
        kafkaTemplate.send(topico, pedido.getId(), pedido);
    }

}