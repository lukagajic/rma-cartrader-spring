package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleSQLException(SQLIntegrityConstraintViolationException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Pokusavate da unesete duplikat!"
        ), HttpStatus.BAD_REQUEST);
    }
}
