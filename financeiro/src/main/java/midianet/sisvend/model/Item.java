package midianet.sisvend.model;

import lombok.Data;

@Data
public class Item {
    private String produto;
    private Double quantidade;
    private Double valor;
}
