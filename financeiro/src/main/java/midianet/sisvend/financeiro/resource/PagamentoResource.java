package midianet.sisvend.financeiro.resource;

import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.financeiro.broker.PagamentoProducer;
import midianet.sisvend.financeiro.service.PagamentoService;
import midianet.sisvend.model.Pedido;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {
    private final PagamentoService service;

    @PostMapping("/{pedido}")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@PathVariable final String pedido) {
        service.receber(pedido);
    }

}
