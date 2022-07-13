package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Pagamento;
import midianet.sisvend.infra.database.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPagamentosUsecase {

    private final PagamentoRepository repository;

    public List<Pagamento> execute(){
        return repository.findAll();
    }

}