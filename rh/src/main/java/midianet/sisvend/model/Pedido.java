package midianet.sisvend.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pedido implements Serializable {
    private String id;
    private String vendedor;
    private Double valor;
}
