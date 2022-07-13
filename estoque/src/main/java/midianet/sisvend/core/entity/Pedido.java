package midianet.sisvend.core.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    @Id
    private String id;
    
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime data;
    private LocalDateTime entrada;

    private String cliente;
    private Double frete;
    private Status status;
    private String rastreio;

    @JoinColumn(name = "pedido_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;

    public enum Status{
        NOVO, RESERVADO, RECEBIDO, ENVIADO
    }

}