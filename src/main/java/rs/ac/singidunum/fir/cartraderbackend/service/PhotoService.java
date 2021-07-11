package rs.ac.singidunum.fir.cartraderbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.cartraderbackend.entity.Photo;
import rs.ac.singidunum.fir.cartraderbackend.exception.notfound.PhotoNotFoundException;
import rs.ac.singidunum.fir.cartraderbackend.repository.PhotoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo getPhotoById(Long photoId) {
        return photoRepository.findById(photoId).orElseThrow(() -> new PhotoNotFoundException());
    }
}
