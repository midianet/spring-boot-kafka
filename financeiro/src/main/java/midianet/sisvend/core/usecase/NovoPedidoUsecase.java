package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoPedidoUsecase {
    private final PedidoRepository repository;

    @Transactional
    public void execute(@NonNull final Pedido pedido){
        pedido.setStatus(Pedido.Status.AGUARDANDO_PAGAMENTO);
        repository.save(pedido);
        log.info("\n [Módulo Financeiro]\n Pedido recebido: {}\n Viabilizando o pagamento do cliente: {}\n Valor: {}",
            pedido.getId(),
            pedido.getCliente(),
            pedido.getValor());
    }

}