package midianet.sisvend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Pedido implements Serializable {
    @Id
    private String id;
    private String cliente;
    private String vendedor;
    private Double valor;
    private Double frete;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<Item> itens;
}
