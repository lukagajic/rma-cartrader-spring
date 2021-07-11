package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.Favorite;
import rs.ac.singidunum.fir.cartraderbackend.entity.User;
import rs.ac.singidunum.fir.cartraderbackend.entity.Vehicle;
import rs.ac.singidunum.fir.cartraderbackend.exception.auth.UserForbiddenException;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.VehicleNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.FavoriteRepository;
import rs.ac.singidunum.fir.cartraderbackend.repository.UserRepository;
import rs.ac.singidunum.fir.cartraderbackend.repository.VehicleRepository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoriteService {
    @Autowired
    private AuthService authService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    public Set<VehicleDTO> getFavoritesByUserId(Long userId) {
        User currentUser = authService.getCurrentUser();

        if (currentUser.getId() != userId) {
            throw new UserForbiddenException();
        }

        Set<VehicleDTO> favorites = userRepository.findById(currentUser.getId())
                .get()
                .getFavorites()
                .stream()
                .map(favorite -> vehicleService.mapToDTO(favorite.getVehicle()))
                .collect(Collectors.toSet());

        return favorites;
    }

    @Transactional
    public void addToFavorites(Long vehicleId) {
        User currentUser = authService.getCurrentUser();

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new VehicleNotFoundException()
        );

        Favorite favorite = new Favorite();
        favorite.setUser(currentUser);
        favorite.setVehicle(vehicle);

        favoriteRepository.save(favorite);
    }

    @Transactional
    public void deleteVehicleFromFavorites(Long vehicleId) {
        User currentUser = authService.getCurrentUser();

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new VehicleNotFoundException());

        favoriteRepository.deleteByUserAndVehicle(currentUser, vehicle);
    }
}
