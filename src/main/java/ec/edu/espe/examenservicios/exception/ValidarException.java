package ec.edu.espe.examenservicios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ValidarException extends RuntimeException{

    public ValidarException(String mensaje){
        super(mensaje);
    }
}
