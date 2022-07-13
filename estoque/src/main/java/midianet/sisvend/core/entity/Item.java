package midianet.sisvend.core.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {
    @Id
    private Integer id;
    private String sku;
    private String descricao;
    private Double quantidade;
}
