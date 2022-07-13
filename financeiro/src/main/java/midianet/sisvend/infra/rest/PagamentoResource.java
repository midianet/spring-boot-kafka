package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.core.usecase.ListarPagamentosUsecase;
import midianet.sisvend.core.usecase.ReceberPagamentoUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {
    private final ReceberPagamentoUsecase receberPagamentoUsecase;
    private final ListarPagamentosUsecase listarPagamentosUsecase;

    @PostMapping("/{pedido}")
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@PathVariable final String pedido) {
        receberPagamentoUsecase.execute(pedido);
    }

    @GetMapping
    public List<Pagamento> list(){
        return listarPagamentosUsecase.execute();
    }

}
