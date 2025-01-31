package codespace.forumapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.FThread;
import codespace.forumapi.repository.FThreadRepository;

@RestController
@RequestMapping("/api/fthread")
public class FThreadController {

    @Autowired
    private FThreadRepository fthreadRepository;

    // Define your endpoints here
    @GetMapping
    public List<FThread> getAllFThreads() {
        return fthreadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FThread> getFThreadById(@PathVariable int id) {
        return fthreadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FThread> createFThread(@RequestBody FThread fthread) {
        FThread createdFThread = fthreadRepository.save(fthread);
        return ResponseEntity.ok(createdFThread);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThread> updateFThread(@PathVariable int id, @RequestBody FThread updatedFThread) {
        Optional<FThread> existingFThreads = fthreadRepository.findById(id);
        if (existingFThreads.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            FThread existingFThread = existingFThreads.get();
            // Update fields as needed
            existingFThread.setForumID(updatedFThread.getForumID());
            existingFThread.setName(updatedFThread.getName());
            existingFThread.setText(updatedFThread.getText());
            // Add more setters as per your FThread model
            
            FThread savedFThread = fthreadRepository.save(existingFThread);
            return ResponseEntity.ok(savedFThread);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFThread(@PathVariable int id) {
        if(!fthreadRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else{
            fthreadRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
