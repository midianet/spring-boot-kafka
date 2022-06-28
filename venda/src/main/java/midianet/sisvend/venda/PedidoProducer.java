package midianet.sisvend.venda;

import midianet.sisvend.model.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class PedidoProducer {

    @Value("${pedido.topico}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoProducer(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Pedido send(final @RequestBody Pedido pedido) {
        final String key = UUID.randomUUID().toString();
        pedido.setId(key);
        kafkaTemplate.send(topico, key,  pedido);
        return pedido;
    }

}
