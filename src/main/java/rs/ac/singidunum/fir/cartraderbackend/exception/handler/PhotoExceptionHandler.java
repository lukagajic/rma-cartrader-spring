package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.PhotoNotFoundException;

@ControllerAdvice
public class PhotoExceptionHandler {
    @ExceptionHandler(value = PhotoNotFoundException.class)
    public ResponseEntity<ApiResponse> handlePhotoNotFoundException(PhotoNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena slika automobila ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
