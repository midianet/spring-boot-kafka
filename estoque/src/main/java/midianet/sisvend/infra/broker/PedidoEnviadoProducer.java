package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Envio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEnviadoProducer {

    @Value("${topico.pedido.envio}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final Envio envio) {
        kafkaTemplate.send(topico, envio);
    }

}