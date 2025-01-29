package codespace.forumapi.controller;

import org.springframework.web.bind.annotation.*;
import codespace.forumapi.model.User;
import codespace.forumapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // Define your endpoints here
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        User existingUser = existingUserOptional.get();
        // Update fields as needed
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setDescription(updatedUser.getDescription());
        // Add more setters as per your User model
        
        User savedUser = userRepository.save(existingUser);
        return ResponseEntity.ok(savedUser);
    }
}
