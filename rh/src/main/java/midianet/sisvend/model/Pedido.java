package midianet.sisvend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pedido implements Serializable {
    private String id;
    private String vendedor;
    private Double valor;
}
