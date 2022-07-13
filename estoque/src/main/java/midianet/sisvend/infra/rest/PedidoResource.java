package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.core.usecase.ListarPedidosUsecase;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final ListarPedidosUsecase listarPedidos;

    @GetMapping
    public List<Pedido> list(){
        return listarPedidos.execute();
    }

}