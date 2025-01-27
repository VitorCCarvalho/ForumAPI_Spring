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
    public ResponseEntity<FThread> getFThreadById(@PathVariable int id) {
        return fthreadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FThread createFThread(@RequestBody FThread fthread) {
        return fthreadRepository.save(fthread);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThread> updateFThread(@PathVariable int id, @RequestBody FThread fthread) {
        return fthreadRepository.findById(id)
                .map(existingFThread -> {
                    existingFThread.setTitle(fthread.getTitle());
                    existingFThread.setContent(fthread.getContent());
                    return fthreadRepository.save(existingFThread);
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFThread(@PathVariable int id) {
        return fthreadRepository.findById(id)
                .map(fthread -> {
                    fthreadRepository.delete(fthread);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
