package ec.edu.espe.examenservicios.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "cursos")
@TypeAlias("cursos")
@Data
@Builder
public class Curso {

    @Id
    private String id;

    private String paralelo;

    private Integer nivel;

    @DocumentReference
    List<Estudiante> estudiantes;
}
