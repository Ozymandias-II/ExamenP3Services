package ec.edu.espe.examenservicios.resource;

import ec.edu.espe.examenservicios.model.Curso;
import ec.edu.espe.examenservicios.model.Estudiante;
import ec.edu.espe.examenservicios.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService service;

    @GetMapping("/porNivel/{nivel}")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorNivel(@PathVariable("nivel") Integer nivel){
        return ResponseEntity.ok(service.encontrarEstudiantesPorNivel(nivel));
    }

    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(service.crearEstudiante(estudiante));
    }

    @PutMapping
    public ResponseEntity<Curso> asignarCurso(@RequestBody String cedula, Integer nivel){
        return ResponseEntity.ok(service.asignarEstudiante(cedula, nivel));
    }

    @GetMapping("/nivelYParalelo")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorNivelYParalelo(@RequestBody Integer nivel, String paralelo){
        return ResponseEntity.ok(service.estudiantesPorNivelYParalelo(nivel, paralelo));
    }

}
