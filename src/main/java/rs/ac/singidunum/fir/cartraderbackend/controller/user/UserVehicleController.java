package rs.ac.singidunum.fir.cartraderbackend.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.AddVehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.service.VehicleService;

@RestController
@RequestMapping("/api/v1/secured/vehicles")
public class UserVehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody AddVehicleDTO addVehicleDTO) {
        return new ResponseEntity<>(vehicleService.addVehicle(addVehicleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<ApiResponse> deleteVehicleById(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Vozilo uspešno obrisano!"), HttpStatus.OK);
    }
}
