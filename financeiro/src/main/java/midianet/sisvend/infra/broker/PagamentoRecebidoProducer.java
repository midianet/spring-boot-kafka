package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.core.entity.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@RequiredArgsConstructor
public class PagamentoRecebidoProducer {

    @Value("${topico.pedido.pagamento}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final @RequestBody Pagamento pagamento) {
        kafkaTemplate.send(topico, pagamento);
    }

}
