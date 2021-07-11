package rs.ac.singidunum.fir.cartraderbackend.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.CategoryNotFoundException;

@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(value = CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(
            false,
            "Tražena kategorija ne postoji u bazi podataka"
        ), HttpStatus.NOT_FOUND);
    }
}
