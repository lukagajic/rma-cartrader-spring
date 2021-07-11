package rs.ac.singidunum.fir.cartraderbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.cartraderbackend.entity.SecurityFeature;

import java.util.Optional;

@Repository
public interface SecurityFeatureRepository extends JpaRepository<SecurityFeature, Long> {
    Optional<SecurityFeature> findByName(String name);
}
