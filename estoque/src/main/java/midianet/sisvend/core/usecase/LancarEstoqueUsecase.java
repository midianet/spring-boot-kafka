package midianet.sisvend.core.usecase;

import lombok.RequiredArgsConstructor;

import midianet.sisvend.core.entity.Estoque;
import midianet.sisvend.infra.database.EstoqueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LancarEstoqueUsecase {

    private final EstoqueRepository estoqueRepository;

    @Transactional
    public void execute(final String sku, final LancarEstoqueIn lancamento){
        final var estoque = estoqueRepository.findBySku(sku)
            .orElse(Estoque.builder()
                    .sku(sku)
                    .descricao(lancamento.descricao)
                    .quantidade(0.0).build());
        estoque.setQuantidade(estoque.getQuantidade() + lancamento.quantidade);
        estoqueRepository.save(estoque);
    }

    public record LancarEstoqueIn(String descricao, Double quantidade){}

}