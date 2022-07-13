package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;
import midianet.sisvend.core.entity.Estoque;
import midianet.sisvend.infra.database.EstoqueRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ObterEstoqueUsecase {

    private final EstoqueRepository estoqueRepository;

    public Estoque execute(final String sku) {
        return estoqueRepository.findBySku(sku)
                .orElseThrow(() -> new EntityNotFoundException("Estoque não econtrado"));
    }

}
