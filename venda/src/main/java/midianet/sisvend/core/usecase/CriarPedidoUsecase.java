package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Item;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.infra.broker.PedidoCriadoProducer;
import midianet.sisvend.infra.database.PedidoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CriarPedidoUsecase {
    private final PedidoRepository repository;
    private final PedidoCriadoProducer producer;

    @Transactional
    public CriarPedidoOut execute(final CriarPedidoIn create){
        final var uuid = UUID.randomUUID().getMostSignificantBits();
        final var pedido = repository.save(Pedido.builder()
            .id(String.valueOf(uuid < 0 ? uuid * -1: uuid))
            .data(LocalDateTime.now())
            .cliente(create.cliente)
            .vendedor(create.vendedor)
            .valor(create.valor)
            .frete(create.frete)
            .itens(create.itens)
            .status(Pedido.Status.NOVO).build());
        producer.send(pedido);
        log.info("\n [Módulo de Vendas]\n Novo Pedido: {}\n Cliente: {}\n Vendedor: {}\n Total: {}\n Frete: {}\n Items:\n{}",
            pedido.getId(),
            pedido.getCliente(),
            pedido.getVendedor(),
            pedido.getValor(),
            pedido.getFrete(),
            pedido.getItens()
                .stream()
                .map(item -> String.format(" %s - Descrição: %s, Qtd %s, Val %s", item.getSku(), item.getDescricao(), item.getQuantidade(), item.getValor()))
                .collect(Collectors.joining("\n")));
        return new CriarPedidoOut(pedido.getId());
    }
    public record CriarPedidoIn(String cliente, String vendedor, Double valor, Double frete, List<Item> itens){}

    public record CriarPedidoOut(String id){}

}