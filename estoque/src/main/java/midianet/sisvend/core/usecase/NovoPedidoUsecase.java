package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoPedidoUsecase {
    private final PedidoRepository pedidoRepository;

    private final ReservaPedidoUsecase reservarPedido;

    @Transactional
    public void execute(@NonNull final Pedido pedido){
        log.info("\n [Módulo Estoque]\n Pedido recebido: {}",pedido.getId());
        pedido.setStatus(Pedido.Status.RESERVADO);
        pedido.setEntrada(LocalDateTime.now());
        reservarPedido.execute(pedido);
        pedidoRepository.save(pedido);
    }

}