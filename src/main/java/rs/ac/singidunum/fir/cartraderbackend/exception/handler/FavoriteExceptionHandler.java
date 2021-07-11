package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.FavoriteNotFoundException;

@ControllerAdvice
public class FavoriteExceptionHandler {
    @ExceptionHandler(value = FavoriteNotFoundException.class)
    public ResponseEntity<ApiResponse> handleFavoriteNotFoundException(FavoriteNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Traženi omiljeni oglas ne postoji u bazi podataka"
        ), HttpStatus.NOT_FOUND);
    }
}
