package ec.edu.espe.examenservicios.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiantes")
@TypeAlias("estudiantes")
@Data
@Builder
public class Estudiante {

    @Id
    private String id;

    @Indexed(unique = true)
    private String cedula;

    private String apellidos;

    private String nombres;

    private Integer nivel;
}
