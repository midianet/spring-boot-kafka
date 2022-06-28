package midianet.sisvend.estoque.broker;

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
        log.info("\n [Módulo Estoque]\n Confirmado Pagamento\n Pedido: {}\n Dando baixa no estoque do produtos:\n{}\n Enviando as Mercadorias",
            pedido.getId(),
            pedido.getItens()
                .stream()
                .map(item -> String.format("  %s -> %s", item.getProduto(), item.getQuantidade()))
                .collect(Collectors.joining("\n")));
    }

}