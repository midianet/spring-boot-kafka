package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Envio;
import midianet.sisvend.core.usecase.PedidoEnviadoUsecase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoEnviadoConsumer {

    private final PedidoEnviadoUsecase pedidoEnviado;

    @KafkaListener(topics = "${topico.pedido.envio}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(final Envio envio) {
        pedidoEnviado.execute(envio);
    }

}