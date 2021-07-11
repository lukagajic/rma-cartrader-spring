package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserAuthResponse;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserLoginDTO;
import rs.ac.singidunum.fir.cartraderbackend.dto.auth.UserRegisterDTO;
import rs.ac.singidunum.fir.cartraderbackend.entity.City;
import rs.ac.singidunum.fir.cartraderbackend.entity.User;
import rs.ac.singidunum.fir.cartraderbackend.repository.UserRepository;
import rs.ac.singidunum.fir.cartraderbackend.security.JwtProvider;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CityService cityService;

    @Autowired
    private JwtProvider jwtProvider;


    public UserAuthResponse login(UserLoginDTO userLoginDTO) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);

        return new UserAuthResponse(token, userLoginDTO.getEmail(), userRepository.findByEmail(
            ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
        ).get().getId());
    }

    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
                                                                                            .getAuthentication()
                                                                                            .getPrincipal();

        return userRepository.findByEmail(principal.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Ne postoji korisnik sa datim email-om"));
    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());
        user.setPasswordHash(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setAddress(userRegisterDTO.getAddress());
        user.setPostalCode(userRegisterDTO.getPostalCode());
        user.setPhoneNumber(userRegisterDTO.getPhoneNumber());

        City city = cityService.getCityById(userRegisterDTO.getCityId());
        user.setCity(city);
        userRepository.save(user);
    }
}
