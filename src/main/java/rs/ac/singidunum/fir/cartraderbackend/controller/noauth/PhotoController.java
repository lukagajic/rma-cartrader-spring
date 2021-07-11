package rs.ac.singidunum.fir.cartraderbackend.controller.noauth;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.fir.cartraderbackend.entity.Photo;
import rs.ac.singidunum.fir.cartraderbackend.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/photos")
@AllArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/{photoId}")
    public Photo getPhotoById(@PathVariable Long photoId) {
        return photoService.getPhotoById(photoId);
    }
}
