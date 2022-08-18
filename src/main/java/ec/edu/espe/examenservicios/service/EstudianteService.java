package ec.edu.espe.examenservicios.service;

import ec.edu.espe.examenservicios.exception.NotFoundException;
import ec.edu.espe.examenservicios.exception.ValidarException;
import ec.edu.espe.examenservicios.model.Curso;
import ec.edu.espe.examenservicios.model.Estudiante;
import ec.edu.espe.examenservicios.repository.CursoRepository;
import ec.edu.espe.examenservicios.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    private final CursoRepository cursoRepository;

    public List<Estudiante> encontrarEstudiantesPorNivel(Integer nivel){
        return estudianteRepository.findByNivel(nivel);
    }

    public Estudiante crearEstudiante(Estudiante estudiante){
        Optional<Estudiante> validarEst = estudianteRepository.findByCedula(estudiante.getCedula());
        if(validarEst.isPresent()){
          throw new ValidarException(
                  "El estudiante ya se encuentra registrado");
        }

        if (validarEst.get().getNivel() > 10){
            throw new ValidarException("El nivel no es valido");
        }

        return this.estudianteRepository.save(estudiante);
    }

    public Curso asignarEstudiante(String cedula, Integer nivel){
        String[] paralelo = {"A", "B", "C"};
        Estudiante estudiante = this.obtenerPorCedula(cedula);
        Integer asignar = randInt(1, 3);

        Optional<Curso> asignarCurso = cursoRepository.findByParaleloAndNivel(paralelo[asignar], nivel);

        asignarCurso.get().getEstudiantes().add(estudiante);

        this.cursoRepository.save(asignarCurso.get());

        return asignarCurso.get();

    }

    public Estudiante obtenerPorCedula(String cedula){
        return estudianteRepository.findByCedula(cedula)
                .orElseThrow(
                        () -> new NotFoundException("El estudiante no existe"));

    }

    public List<Estudiante> estudiantesPorNivelYParalelo(Integer nivel, String paralelo){

        Curso curso = cursoRepository.findByParaleloAndNivel(paralelo, nivel).get();

        return curso.getEstudiantes();

    }

    public void controlDistribucionEstudiantes(Integer nivel){
        List<Curso> cursosNivel = cursoRepository.findByNivel(nivel);
    }
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
