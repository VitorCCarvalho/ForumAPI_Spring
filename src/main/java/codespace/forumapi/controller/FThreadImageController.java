package codespace.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.FThreadImage;
import codespace.forumapi.repository.FThreadImageRepository;

@RestController
@RequestMapping("/api/fthreadimage")
public class FThreadImageController {

    @Autowired
    private FThreadImageRepository fthreadimageRepository;

    // Define your endpoints here
    @GetMapping
    public List<FThreadImage> getAllFThreadImages() {
        return fthreadimageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FThreadImage> getFThreadImageById(@PathVariable int id) {
        return fthreadimageRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FThreadImage> createFThreadImage(@RequestBody FThreadImage fthreadimage) {
        return ResponseEntity.ok(fthreadimageRepository.save(fthreadimage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThreadImage> updateFThreadImage(@PathVariable int id, @RequestBody FThreadImage fthreadimage) {
        return fthreadimageRepository.findById(id)
                .map(existingFThreadImage -> {
                    existingFThreadImage.setFThreadId(fthreadimage.getFThreadId());
                    existingFThreadImage.setImgId(fthreadimage.getImgId());
                    return fthreadimageRepository.save(existingFThreadImage);
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFThreadImage(@PathVariable int id) {
       if(!fthreadimageRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else{
            fthreadimageRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}