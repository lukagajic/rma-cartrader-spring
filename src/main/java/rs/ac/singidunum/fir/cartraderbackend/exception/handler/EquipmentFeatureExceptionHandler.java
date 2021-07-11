package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.EquipmentFeatureNotFoundException;

@ControllerAdvice
public class EquipmentFeatureExceptionHandler {
    @ExceptionHandler(value = EquipmentFeatureNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEquipmentFeatureNotFoundException(EquipmentFeatureNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                "Tražena stavka opreme ne postoji u bazi podataka!"
        ), HttpStatus.NOT_FOUND);
    }
}
