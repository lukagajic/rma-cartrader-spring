package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.ColorType;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.ColorTypeNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.ColorTypeRepository;

import java.util.List;

@Service
public class ColorTypeService {
    @Autowired
    private ColorTypeRepository colorTypeRepository;

    public List<ColorType> getAllColorTypes() {
        return colorTypeRepository.findAll();
    }

    public ColorType getColorTypeById(Long colorTypeId) {
        return colorTypeRepository.findById(colorTypeId).orElseThrow(() -> new ColorTypeNotFoundException());
    }
}
