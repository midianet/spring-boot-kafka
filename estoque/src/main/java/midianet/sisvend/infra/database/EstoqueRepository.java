package midianet.sisvend.infra.database;

import midianet.sisvend.core.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque,Integer> {
    Optional<Estoque> findBySku(String sku);

    List<Estoque> findByDescricaoOrderByQuantidade(String descricao);

}