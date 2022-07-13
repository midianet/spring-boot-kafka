package midianet.sisvend.core.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Pedido implements Serializable {
    @Id
    private String id;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime data;

    private String cliente;
    private String vendedor;
    private Double valor;
    private Double frete;
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<Item> itens;

    public enum Status{
        NOVO, AGUARDANDO_PAGAMENTO, RECEBIDO
    }

}