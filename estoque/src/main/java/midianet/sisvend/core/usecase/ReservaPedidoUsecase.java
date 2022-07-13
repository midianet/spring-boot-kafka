package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.database.EstoqueRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservaPedidoUsecase {
    private final EstoqueRepository estoqueRepository;

    public void execute(final Pedido pedido){
        pedido.getItens().forEach(item -> estoqueRepository.findBySku(item.getSku())
            .ifPresent(estoque -> {
                estoque.setQuantidade(estoque.getQuantidade() - item.getQuantidade());
                estoqueRepository.save(estoque);
            }));
        log.info("\n [Módulo Estoque]\n Reservando os Itens do Pedido: {}\n{}",
            pedido.getId(),
            pedido.getItens()
                .stream()
                .map(item -> String.format("  %s - %s [%s]", item.getSku(), item.getDescricao(), item.getQuantidade()))
                .collect(Collectors.joining("\n")));
    }

}