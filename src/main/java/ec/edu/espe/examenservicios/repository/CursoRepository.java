package ec.edu.espe.examenservicios.repository;

import ec.edu.espe.examenservicios.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByNivel(Integer nivel);

    Optional<Curso> findByParaleloAndNivel(String paralelo, Integer nivel);
}
