package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Envio;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.broker.PedidoEnviadoProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnviarPedidoUsecase {

    private final PedidoEnviadoProducer envioProducer;

    public void execute(final Pedido pedido){
        final var uuid = UUID.randomUUID().getMostSignificantBits();
        final var envio = Envio.builder()
            .pedido(pedido.getId())
            .rastreio(String.valueOf(uuid < 0 ? uuid * -1: uuid)).build();
        envioProducer.send(envio);
        log.info("\n [Módulo Estoque]\n Enviando o Pedido: {}\nRastreio:{}",
            pedido.getId(),
            envio.getRastreio());
    }

}