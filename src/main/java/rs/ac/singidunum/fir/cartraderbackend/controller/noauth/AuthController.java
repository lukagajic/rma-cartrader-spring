package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserAuthResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserLoginDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserRegisterDTO;
import rs.ac.singidunum.fir.cartraderbackend.service.AuthService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        authService.register(userRegisterDTO);
        return new ResponseEntity<>(new ApiResponse(true, "Uspesna registracija"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> login(@RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<>(authService.login(userLoginDTO), HttpStatus.OK);
    }


}
