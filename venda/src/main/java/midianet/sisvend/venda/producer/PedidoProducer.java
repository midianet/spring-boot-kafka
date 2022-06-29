package midianet.sisvend.venda.producer;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class PedidoProducer {

    @Value("${pedido.topico}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PedidoProducer(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Pedido send(final @RequestBody Pedido pedido) {
        final var id = UUID.randomUUID().getMostSignificantBits();
        final String key = String.valueOf(id < 0 ? id * -1: id);
        pedido.setId(key);
        kafkaTemplate.send(topico, key,  pedido);
        return pedido;
    }

}
