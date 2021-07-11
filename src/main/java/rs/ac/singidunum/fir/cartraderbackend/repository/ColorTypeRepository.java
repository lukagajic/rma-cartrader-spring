package rs.ac.singidunum.fir.cartraderbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.cartraderbackend.entity.ColorType;

@Repository
public interface ColorTypeRepository extends JpaRepository<ColorType, Long> {
}
