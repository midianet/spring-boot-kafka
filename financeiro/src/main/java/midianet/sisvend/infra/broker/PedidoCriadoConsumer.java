package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.usecase.NovoPedidoUsecase;
import midianet.sisvend.core.entity.Pedido;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoCriadoConsumer {

    private final NovoPedidoUsecase novoPedidoUsecase;

    @KafkaListener(topics = "${topico.pedido.novo}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final Pedido pedido) {
        novoPedidoUsecase.execute(pedido);
    }

}
