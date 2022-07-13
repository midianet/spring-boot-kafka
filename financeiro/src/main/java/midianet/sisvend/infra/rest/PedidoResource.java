package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Pedido;
import midianet.sisvend.core.usecase.ListarPedidosUsecase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {
    private final ListarPedidosUsecase listarPedidosUsecase;

    @GetMapping
    public List<Pedido> list(){
        return listarPedidosUsecase.execute();
    }

}