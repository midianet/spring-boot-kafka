package midianet.sisvend.infra.rest;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Comissao;
import midianet.sisvend.core.usecase.ListarComissoes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comissoes")
public class ComissaoResource {

    private final ListarComissoes listarComissoes;

    @GetMapping
    public List<Comissao> list(){
        return listarComissoes.execute();
    }

}