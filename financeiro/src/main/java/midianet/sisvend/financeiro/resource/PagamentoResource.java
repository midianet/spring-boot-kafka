package midianet.sisvend.financeiro.resource;

import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.financeiro.broker.PagamentoProducer;
import midianet.sisvend.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {

    private final PagamentoProducer producer;

    public PagamentoResource(PagamentoProducer producer) {
        this.producer = producer;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody Pedido pedido) {
        log.info("\n [Módulo Financeiro]\n Pagamento recebido\n Pedido: {}\n Cliente: {}\n Valor: {}",
                pedido.getId(),
                pedido.getCliente(),
                pedido.getValor());
        producer.send(pedido);
    }

}
