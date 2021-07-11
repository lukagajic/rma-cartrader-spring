package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.ColorTypeNotFoundException;

@ControllerAdvice
public class ColorTypeExceptionHandler {
    @ExceptionHandler(value = ColorTypeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleColorTypeNotFoundException(ColorTypeNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena boja ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
