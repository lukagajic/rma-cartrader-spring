package rs.ac.singidunum.fir.cartraderbackend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.user.UserDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.service.FavoriteService;
import rs.ac.singidunum.fir.cartraderbackend.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/secured/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/{userId}/favorites")
    public Set<VehicleDTO> getFavoritesByUserId(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @GetMapping("/{userId}/favorites/{vehicleId}")
    public ResponseEntity<ApiResponse> addToFavorites(@PathVariable Long userId, @PathVariable Long vehicleId) {
        favoriteService.addToFavorites(vehicleId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Vozilo dodato u omiljene!"), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile() {
        return new ResponseEntity<UserDTO>(userService.getUserProfile(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/vehicles")
    public ResponseEntity<Set<VehicleDTO>> getVehiclesByUserId(@PathVariable Long userId) {
        return new ResponseEntity<Set<VehicleDTO>>(userService.getVehiclesByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/favorites/{vehicleId}")
    public ResponseEntity<ApiResponse> deleteVehicleFromFavorites(@PathVariable Long userId, @PathVariable Long vehicleId) {
        favoriteService.deleteVehicleFromFavorites(vehicleId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Vozilo uklonjeno iz liste omiljenih!"), HttpStatus.OK);
    }
}
