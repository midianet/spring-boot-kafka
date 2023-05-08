package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Envio;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.broker.PedidoEnviadoProducer;
import midianet.sisvend.infra.database.EstoqueRepository;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LimparTudoUsecase {

    private final EstoqueRepository estoqueRepository;
    private final PedidoRepository pedidoRepository;

    @Transactional
    public void execute(){
        pedidoRepository.deleteAll();
        estoqueRepository.deleteAll();
    }

}