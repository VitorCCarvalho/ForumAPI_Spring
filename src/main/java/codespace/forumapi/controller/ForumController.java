package codespace.forumapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import codespace.forumapi.model.Forum;

@RestController
public class ForumController {
	
	@GetMapping("/forum/teste")
	public String getTeste() {
		Forum forum = new Forum();
		forum.setName("forum");
		forum.setDescription("description");
		
		String resp = new Gson().toJson(forum);
		
		return resp;
	}
}
