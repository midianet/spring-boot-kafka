package midianet.sisvend.venda.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.model.Pedido;
import midianet.sisvend.venda.usecase.CriarPedidoUseCase;
import midianet.sisvend.venda.usecase.ListarPedidoUseCase;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final CriarPedidoUseCase criarService;
    private final ListarPedidoUseCase listarService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody CriarPedidoUseCase.CriarPedidoIn create, HttpServletResponse response) {
        response.setHeader(HttpHeaders.LOCATION, ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(criarService.execute(create).id())
                .toUri()
                .toString());
    }

    @GetMapping
    public List<Pedido> list(){
        return listarService.execute();
    }

}