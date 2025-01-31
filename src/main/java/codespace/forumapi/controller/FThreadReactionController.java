package codespace.forumapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.FThreadReaction;
import codespace.forumapi.repository.FThreadReactionRepository;

@RestController
@RequestMapping("/api/fthreadreactions")
public class FThreadReactionController {

    @Autowired
    private FThreadReactionRepository fthreadreactionRepository;

    // Define your endpoints here
    @GetMapping
    public ResponseEntity<List<FThreadReaction>> getAllFThreadReactions() {
        return ResponseEntity.ok(fthreadreactionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FThreadReaction> getFThreadReactionById(@PathVariable int id) {
        return fthreadreactionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FThreadReaction> createFThreadReaction(@RequestBody FThreadReaction fthreadreaction) {
        return ResponseEntity.ok(fthreadreactionRepository.save(fthreadreaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FThreadReaction> updateFThreadReaction(@PathVariable int id, @RequestBody FThreadReaction fthreadreactionDetails) {
        Optional<FThreadReaction> existingFThreadReactionOptional = fthreadreactionRepository.findById(id);
        if (existingFThreadReactionOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            FThreadReaction existingFThreadReaction = existingFThreadReactionOptional.get();
            existingFThreadReaction.setReaction(fthreadreactionDetails.getReaction());
            return ResponseEntity.ok(fthreadreactionRepository.save(existingFThreadReaction));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFThreadReaction(@PathVariable int id) {
        if(!fthreadreactionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else{
            fthreadreactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
