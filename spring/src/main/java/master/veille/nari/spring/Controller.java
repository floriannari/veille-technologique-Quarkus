package master.veille.nari.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import master.veille.nari.spring.model.Message;
import master.veille.nari.spring.model.User;
import master.veille.nari.spring.service.MessageService;
import master.veille.nari.spring.service.UserService;

@RestController
public class Controller {
	private static final String USERS_PATH = "/users";
	private static final String USERNAME_PATH = USERS_PATH + "/{username}";
	private static final String MESSAGES_PATH = "/messages";
	private static final String USER_MESSAGES_PATH = USERNAME_PATH + MESSAGES_PATH;
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;
	
	@GetMapping(USERS_PATH)
	public List<User> getUsers() {
		return userService.listAll();
	}

	@PostMapping(USERNAME_PATH)
	public User add(@PathVariable String username) {
		return userService.newUser(username);
	}

	@GetMapping(MESSAGES_PATH)
	public List<Message> getAll() {
		return messageService.listAll();
	}

	@GetMapping(USER_MESSAGES_PATH)
	public List<Message> getMessages(@PathVariable String username) {
		return messageService.listByUsername(username);
	}

	@PostMapping(USER_MESSAGES_PATH)
	public Message addMessage(@PathVariable String username, String message) {
		return messageService.newMessage(username, message);
	}
}
