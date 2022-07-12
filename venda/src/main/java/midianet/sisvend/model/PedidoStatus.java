package midianet.sisvend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PedidoStatus implements Serializable {
    private String id;
    private String status;
}