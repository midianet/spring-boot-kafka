package midianet.sisvend.core.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Pagamento implements Serializable {
    private String pedido;
    private Double valor;
    private String vendedor;
}