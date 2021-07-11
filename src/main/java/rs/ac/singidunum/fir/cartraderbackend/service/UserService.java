package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.user.UserDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.vehicle.VehicleDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.User;
import rs.ac.singidunum.fir.cartraderbackend.exception.auth.UserForbiddenException;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.UserNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.FavoriteRepository;
import rs.ac.singidunum.fir.cartraderbackend.repository.UserRepository;
import rs.ac.singidunum.fir.cartraderbackend.repository.VehicleRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private AuthService authService;

    public UserDTO mapToDto(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity().getName());
        userDTO.setPostalCode(user.getPostalCode());
        userDTO.setPhoneNumber(user.getPhoneNumber());

        return userDTO;
    }

    public UserDTO getUserDTOById(Long userId) {
        return mapToDto(userRepository.findById(userId).get());
    }

    public UserDTO getUserProfile() {
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        User foundUser = userRepository.findByEmail(principal.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Ne postoji korisnik sa datim email-om"));
        return mapToDto(foundUser);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
            () -> new UserNotFoundException()
        );
    }

    public Set<VehicleDTO> getVehiclesByUserId(Long userId) {
        User currentUser = authService.getCurrentUser();

        if (currentUser.getId() != userId) {
            throw new UserForbiddenException();
        }

        return currentUser.getVehicles().stream().map(vehicle -> vehicleService.mapToDTO(vehicle)).collect(Collectors.toSet());
    }
}
