package midianet.sisvend.financeiro;

import midianet.sisvend.model.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class PagamentoProducer {

    @Value("${pagamentos.topico}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PagamentoProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody Pedido pedido) {
        final String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topico, key,  pedido);
    }

}
