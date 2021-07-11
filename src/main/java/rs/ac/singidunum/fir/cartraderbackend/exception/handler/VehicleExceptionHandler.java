package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.VehicleNotFoundException;

@ControllerAdvice
public class VehicleExceptionHandler {
    @ExceptionHandler(value = VehicleNotFoundException.class)
    public ResponseEntity<ApiResponse> handleVehicleNotFoundException(VehicleNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Traženo vozilo ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
