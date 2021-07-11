package rs.ac.singidunum.fir.cartraderbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.cartraderbackend.entity.Favorite;
import rs.ac.singidunum.fir.cartraderbackend.entity.User;
import rs.ac.singidunum.fir.cartraderbackend.entity.Vehicle;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    void deleteByUserAndVehicle(User user, Vehicle vehicle);
}
