package codespace.forumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.Post;
import codespace.forumapi.repository.PostRepository;
import java.util.List;
import java.util.Date;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(int id) {
        Optional<Post> post = postRepository.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get posts by thread
    @GetMapping("/thread/{threadId}")
    public ResponseEntity<List<Post>> getPostsByThread(@PathVariable int threadId) {
        Optional<List<Post>> posts = postRepository.findByThreadId(threadId);
        return posts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a single post

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setDateCreated(new Date());
        Post savedPost = postRepository.save(post);
        return ResponseEntity.ok(savedPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post updatedPost) {
        Optional<Post> existingPostOptional = postRepository.findById(id);
        if (existingPostOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else{
            Post existingPost = existingPostOptional.get();
            // Update fields as needed
            existingPost.setText(updatedPost.getText());
            existingPost.setThreadId(updatedPost.getThreadId());
            
            Post savedPost = postRepository.save(existingPost);
            return ResponseEntity.ok(savedPost);
        }
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable int id) {
        if(!postRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else{
            postRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
}
