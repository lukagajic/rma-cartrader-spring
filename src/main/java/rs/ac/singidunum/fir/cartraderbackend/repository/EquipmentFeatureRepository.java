package rs.ac.singidunum.fir.cartraderbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.cartraderbackend.entity.EquipmentFeature;

import java.util.Optional;

@Repository
public interface EquipmentFeatureRepository extends JpaRepository<EquipmentFeature, Long> {
    Optional<EquipmentFeature> findByName(String name);
}
