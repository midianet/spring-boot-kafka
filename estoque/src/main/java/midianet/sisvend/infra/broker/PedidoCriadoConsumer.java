package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.core.usecase.NovoPedidoUsecase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

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
