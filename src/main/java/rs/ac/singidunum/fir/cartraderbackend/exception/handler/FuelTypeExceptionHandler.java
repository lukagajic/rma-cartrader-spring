package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.FuelTypeNotFoundException;

@ControllerAdvice
public class FuelTypeExceptionHandler {
    @ExceptionHandler(value = FuelTypeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleFuelTypeNotFoundException(FuelTypeNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena vrsta goriva ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
