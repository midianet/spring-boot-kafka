package midianet.sisvend.rh;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PagamentoConsumer {

    @KafkaListener(topics = "${pagamentos.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(Pedido pedido) {
        var comissao = pedido.getValor() * 0.10;
        log.info(String.format("Confirmado o pagamento [%s], realizando transferencia da comissão ao vendedor %s no valor de %s",
            pedido.getId(),
            pedido.getVendedor(),
            comissao)
        );
    }

}
