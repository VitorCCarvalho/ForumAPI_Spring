package codespace.forumapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;

import codespace.forumapi.model.Forum;
import codespace.forumapi.repository.ForumRepository;
import java.util.List;

@RestController
public class ForumController {
	
	@Autowired
	private ForumRepository forumRepository;
	

	@GetMapping("/forum")
	public List<Forum> getAllForums() {
		return forumRepository.getAllForums();
	}

	@GetMapping("/forum/{id}")
	public Forum getForumById(@PathVariable int id) {
		return forumRepository.getForumById(id).get();
	}

	@PostMapping("/forum")
	public Forum createForum(@RequestBody Forum forum) {
		return forumRepository.save(forum);
	}
	
	@PutMapping("/forum/{id}")
	public Forum updateForum(@PathVariable int id, @RequestBody Forum forum) {
		return forumRepository.save(forum);
	}
	
	@DeleteMapping("/forum/{id}")
	public void deleteForum(@PathVariable int id) {
		forumRepository.deleteById(id);
	}
}
