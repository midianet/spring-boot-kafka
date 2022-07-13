package midianet.sisvend.infra.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.core.usecase.PagamentoRecebidoUsecase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoRecebidoConsumer {

    private final PagamentoRecebidoUsecase pagamentoRecebido;

    @KafkaListener(topics = "${topico.pedido.pagamento}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(final Pagamento pagamento) {
        pagamentoRecebido.execute(pagamento);
    }

}
