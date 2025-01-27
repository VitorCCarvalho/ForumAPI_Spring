package codespace.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.FThreadReaction;
import codespace.forumapi.repository.FThreadReactionRepository;

@RestController
@RequestMapping("/api/fthreadreaction")
public class FThreadReactionController {

    @Autowired
    private FThreadReactionRepository fthreadreactionRepository;

    // Define your endpoints here
    @GetMapping
    public List<FThreadReaction> getAllFThreadReactions() {
        return fthreadreactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FThreadReaction> getFThreadReactionById(@PathVariable int id) {
        return fthreadreactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FThreadReaction createFThreadReaction(@RequestBody FThreadReaction fthreadreaction) {
        return fthreadreactionRepository.save(fthreadreaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThreadReaction> updateFThreadReaction(@PathVariable int id, @RequestBody FThreadReaction fthreadreactionDetails) {
        return fthreadreactionRepository.findById(id)
                .map(fthreadreaction -> {
                    fthreadreaction.setReaction(fthreadreactionDetails.getReaction());
                    return fthreadreactionRepository.save(fthreadreaction);
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFThreadReaction(@PathVariable int id) {
        return fthreadreactionRepository.findById(id)
                .map(fthreadreaction -> {
                    fthreadreactionRepository.delete(fthreadreaction);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }   
}
