package codespace.forumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.Post;
import codespace.forumapi.repository.PostRepository;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get posts by thread
    @GetMapping("/thread/{threadId}")
    public List<Post> getPostsByThread(@PathVariable int threadId) {
        return postRepository.findByThreadId(threadId);
    }

    // Get a single post
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return postRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        post.setDateCreated(new Date());
        return postRepository.save(post);
    }

    // Update a post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post postDetails) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setText(postDetails.getText());
                    Post updatedPost = postRepository.save(post);
                    return ResponseEntity.ok(updatedPost);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        return postRepository.findById(id)
                .map(post -> {
                    postRepository.delete(post);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
