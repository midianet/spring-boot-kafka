package midianet.sisvend.infra.database;

import midianet.sisvend.core.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque,Integer> {
    Optional<Estoque> findBySku(String sku);
}