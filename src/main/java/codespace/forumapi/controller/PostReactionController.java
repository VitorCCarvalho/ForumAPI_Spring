package codespace.forumapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.PostReaction;
import codespace.forumapi.repository.PostReactionRepository;

@RestController
@RequestMapping("/api/postreaction")
public class PostReactionController {

    @Autowired
    private PostReactionRepository postReactionRepository;

    // Define your endpoints here
    @GetMapping
    public ResponseEntity<List<PostReaction>> getAllPostReactions() {
        List<PostReaction> postreactions = postReactionRepository.findAll();
        return ResponseEntity.ok(postreactions);
    }   

    @GetMapping("/{id}")
    public ResponseEntity<PostReaction> getPostReactionById(@PathVariable int id) {
        return postReactionRepository.findById(id)
                .map(postreaction -> ResponseEntity.ok(postreaction))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostReaction> createPostReaction(@RequestBody PostReaction postreaction) {
        return ResponseEntity.ok(postReactionRepository.save(postreaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostReaction> updatePostReaction(@PathVariable int id, @RequestBody PostReaction postreactionDetails) {
        Optional<PostReaction> existingPostReactionOptional = postReactionRepository.findById(id);
        if (existingPostReactionOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            PostReaction existingPostReaction = existingPostReactionOptional.get();
            existingPostReaction.setReaction(postreactionDetails.getReaction());
            return ResponseEntity.ok(postReactionRepository.save(existingPostReaction));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePostReaction(@PathVariable int id) {
        if(!postReactionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else{
            postReactionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
