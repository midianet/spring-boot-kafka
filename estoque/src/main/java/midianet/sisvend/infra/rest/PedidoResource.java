package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.core.usecase.LimparTudoUsecase;
import midianet.sisvend.core.usecase.ListarPedidosUsecase;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final ListarPedidosUsecase listarPedidos;
    private final LimparTudoUsecase limparTudoUsecase;

    @GetMapping
    public List<Pedido> list(){
        return listarPedidos.execute();
    }

    @PostMapping("/limpar")
    public void limpar(){
        limparTudoUsecase.execute();
    }

}