package midianet.sisvend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private boolean recebido;
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<Item> itens;
}
