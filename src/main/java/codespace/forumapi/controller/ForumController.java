package codespace.forumapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import codespace.forumapi.model.Forum;
import codespace.forumapi.repository.ForumRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forum")
public class ForumController {
	
	@Autowired
	private ForumRepository forumRepository;
	

	@GetMapping
	public ResponseEntity<List<Forum>> getAllForums() {
		return ResponseEntity.ok(forumRepository.getAllForums());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Forum> getForumById(@PathVariable int id) {
		return forumRepository.getForumById(id)
				.map(forum -> ResponseEntity.ok(forum))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum) {
		return ResponseEntity.ok(forumRepository.save(forum));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable int id, @RequestBody Forum forum) {
		Optional<Forum> existingForums = forumRepository.getForumById(id);
		if (existingForums.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else{
			Forum updatedForum = existingForums.get();
			updatedForum.setName(forum.getName());
			updatedForum.setDescription(forum.getDescription());
			
			return ResponseEntity.ok(forumRepository.save(updatedForum));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Forum> deleteForum(@PathVariable int id) {
		if (!forumRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else{
			forumRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
	}
}
