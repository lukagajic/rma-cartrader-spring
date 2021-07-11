package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.DoorCountTypeNotFoundException;

public class DoorCountTypeExceptionHandler {
    @ExceptionHandler(value = DoorCountTypeNotFoundException.class)
    public ResponseEntity<ApiResponse> handleDoorCountTypeNotFoundException(DoorCountTypeNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena opcija za broj vrata ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
