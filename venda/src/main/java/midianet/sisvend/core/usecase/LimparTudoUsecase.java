package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LimparTudoUsecase {
    private final PedidoRepository pedidoRepository;

    @Transactional
    public void execute(){
        pedidoRepository.deleteAll();
    }

}