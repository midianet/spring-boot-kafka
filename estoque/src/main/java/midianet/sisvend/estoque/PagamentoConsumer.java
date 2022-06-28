package midianet.sisvend.estoque;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.stream.Collectors;

@Slf4j
@Component
public class PagamentoConsumer {

    @KafkaListener(topics = "${pagamentos.topico}", groupId = "${spring.kafka.consumer.pagamento.group-id}")
    public void consumer(Pedido pedido) {
        log.info(String.format("Confirmado o pagamento [%s], dando baixa no estoque do produtos:\n %s",
            pedido.getId(),
            pedido.getItens()
                .stream()
                .map(item -> String.format("  %s [%s]", item.getProduto(), item.getQuantidade()))
                .collect(Collectors.joining("\n")))
        );
    }

}
