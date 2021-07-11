package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.GearboxTypeNotFoundException;

@ControllerAdvice
public class GearboxTypeExceptionHandler {
    @ExceptionHandler(value = GearboxTypeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleGearboxTypeNotFoundException(GearboxTypeNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena vrsta menjača ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
