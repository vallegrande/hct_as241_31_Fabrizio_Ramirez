package hct.Ramirez.Fabrizio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "cliente")
public class Cliente {

    @Id
    private String id;

    @Field("DNI")
    private String dni;

    private String nombres;
    private String apellidos;
    private Integer celular;
    private String  correo;
    private String licencia;
    private String estado;
}