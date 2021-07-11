package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CityNotFoundException;

@ControllerAdvice
public class CityExceptionHandler {
    @ExceptionHandler(value = CityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCityNotFoundException(CityNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Traženi grad ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
