package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Estoque;
import midianet.sisvend.core.usecase.LancarEstoqueUsecase;
import midianet.sisvend.core.usecase.ObterEstoqueUsecase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estoque")
public class EstoqueResource {

    private final ObterEstoqueUsecase obterEstoque;
    private final LancarEstoqueUsecase lancarEstoque;

    @GetMapping("/{sku}")
    public Estoque get(@PathVariable final String sku){
        return obterEstoque.execute(sku);
    }

    @PostMapping("/{sku}")
    public void post(@PathVariable final String sku, @RequestBody LancarEstoqueUsecase.LancarEstoqueIn lancamento){
        lancarEstoque.execute(sku,lancamento);
    }

}