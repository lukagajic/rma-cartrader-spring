package rs.ac.singidunum.fir.cartraderbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.cartraderbackend.entity.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
}
