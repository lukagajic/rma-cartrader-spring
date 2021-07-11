package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.auth.UserForbiddenException;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.UserNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(value = UserForbiddenException.class)
    public ResponseEntity<ApiResponse> handleUserForbiddenException(UserForbiddenException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Nije Vam dozvoljen pristup ovom resursu!"
        ), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Korisnik sa datim ID-jem ne postoji u bazi podataka!"
        ), HttpStatus.FORBIDDEN);
    }
}
