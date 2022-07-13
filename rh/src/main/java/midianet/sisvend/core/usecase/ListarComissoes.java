package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import midianet.sisvend.core.entity.Comissao;
import midianet.sisvend.infra.database.ComissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarComissoes {

    private final ComissaoRepository repository;

    public List<Comissao> execute(){
        return repository.findAll();
    }

}