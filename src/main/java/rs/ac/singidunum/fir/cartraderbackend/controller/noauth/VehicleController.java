package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.singidunum.fir.cartraderbackend.dto.general.ApiResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.service.VehicleService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/public/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicleDTOs();
    }

    @GetMapping("/{vehicleId}")
    public VehicleDTO getVehicleById(@PathVariable Long vehicleId) {
        return vehicleService.getVehicleDTOById(vehicleId);
    }

    @PostMapping("/search")
    public List<VehicleDTO> search(@RequestBody  Map<String, String> searchParameters) {
        return vehicleService.search(searchParameters);
    }

    @PostMapping("/{vehicleId}/photos/upload")
    public ResponseEntity<ApiResponse> uploadImageForVehicle(@PathVariable Long vehicleId,
                                                             @RequestParam("imageFile") MultipartFile imageFile) {
        vehicleService.uploadImageForVehicle(vehicleId, imageFile);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Fotografija uspešno dodata"), HttpStatus.CREATED);
    }
}
