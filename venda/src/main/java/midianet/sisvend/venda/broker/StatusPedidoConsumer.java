package midianet.sisvend.venda.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.PedidoStatus;
import midianet.sisvend.venda.usecase.AlterarStatusPedidoUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StatusPedidoConsumer {
    private final AlterarStatusPedidoUseCase service;

    @KafkaListener(topics = "${pedido.status.topico}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(final PedidoStatus status) {
        service.execute(status);
    }
}
