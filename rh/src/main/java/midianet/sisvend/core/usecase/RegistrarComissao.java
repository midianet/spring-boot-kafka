package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Comissao;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.ComissaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrarComissao {

    private final ComissaoRepository repository;

    public void execute(final Pedido pedido){
        final var comissao = pedido.getValor() * 0.10;
        repository.save(Comissao.builder()
            .data(LocalDate.now())
            .vendedor(pedido.getVendedor())
            .valor(pedido.getValor()).build());
        log.info("\n [Módulo RH]\n Confirmado o pagamento\n Pedido: {}\n Registrando comissão do vendedor: {}\n Comissão: {}",
            pedido.getId(),
            pedido.getVendedor(),
            comissao);
    }

}