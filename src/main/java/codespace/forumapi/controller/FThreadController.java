package codespace.forumapi.controller;

import java.util.List;

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
    public List<FThread> getFThreadById(@PathVariable int id) {
        return fthreadRepository.findById(id);
    }

    @PostMapping
    public FThread createFThread(@RequestBody FThread fthread) {
        return fthreadRepository.save(fthread);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThread> updateFThread(@PathVariable int id, @RequestBody FThread updatedFThread) {
        List<FThread> existingFThreads = fthreadRepository.findById(id);
        if (existingFThreads.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        FThread existingFThread = existingFThreads.get(0);
        // Update fields as needed
        existingFThread.setForumID(updatedFThread.getForumID());
        existingFThread.setName(updatedFThread.getName());
        existingFThread.setText(updatedFThread.getText());
        // Add more setters as per your FThread model
        
        FThread savedFThread = fthreadRepository.save(existingFThread);
        return ResponseEntity.ok(savedFThread);
    }
}
