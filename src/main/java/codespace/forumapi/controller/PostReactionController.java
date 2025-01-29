package codespace.forumapi.controller;

import java.util.List;

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
    public PostReaction createPostReaction(@RequestBody PostReaction postreaction) {
        return postReactionRepository.save(postreaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostReaction> updatePostReaction(@PathVariable int id, @RequestBody PostReaction postreactionDetails) {
        return postReactionRepository.findById(id)
                .map(postreaction -> {
                    postreaction.setReaction(postreactionDetails.getReaction());
                    return postReactionRepository.save(postreaction);
                })
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePostReaction(@PathVariable int id) {
        return postReactionRepository.findById(id)
                .map(postreaction -> {
                    postReactionRepository.delete(postreaction);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
