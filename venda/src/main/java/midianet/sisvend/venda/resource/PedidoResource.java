package midianet.sisvend.venda.resource;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import midianet.sisvend.venda.PedidoProducer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final PedidoProducer producer;

    public PedidoResource(PedidoProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody Pedido pedido, HttpServletResponse response) {
        pedido = producer.send(pedido);
        response.setHeader(HttpHeaders.LOCATION, ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri().toString());
    }

}
