package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.core.usecase.RegistrarComissao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoConsumer {
    private final RegistrarComissao registrarComissao;
    @KafkaListener(topics = "${pagamentos.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(Pedido pedido) {
        registrarComissao.execute(pedido);
    }

}