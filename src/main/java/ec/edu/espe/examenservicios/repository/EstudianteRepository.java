package ec.edu.espe.examenservicios.repository;

import ec.edu.espe.examenservicios.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    List<Estudiante> findByNivel(Integer nivel);

    Optional<Estudiante> findByCedula(String cedula);
}
