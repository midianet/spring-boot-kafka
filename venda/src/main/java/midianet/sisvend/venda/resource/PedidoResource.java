package midianet.sisvend.venda.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import midianet.sisvend.venda.producer.PedidoProducer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final PedidoProducer producer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody Pedido pedido, HttpServletResponse response) {
        pedido = producer.send(pedido);
        response.setHeader(HttpHeaders.LOCATION, ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri().toString());
        log.info("\n [Módulo de Vendas]\n Pedido recebido: {}\n Cliente: {}\n Vendedor: {}\n Total {}\n Frete: {}\n Items:\n{}",
            pedido.getId(),
            pedido.getCliente(),
            pedido.getVendedor(),
            pedido.getValor(),
            pedido.getFrete(),
            pedido.getItens()
                    .stream()
                    .map(item -> String.format(" Descrição: %s , Q %s, V %s", item.getProduto(), item.getQuantidade(), item.getValor()))
                    .collect(Collectors.joining("\n")));
    }

}
