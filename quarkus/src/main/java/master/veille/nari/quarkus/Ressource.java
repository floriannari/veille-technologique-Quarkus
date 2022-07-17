package master.veille.nari.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import master.veille.nari.quarkus.data.Message;
import master.veille.nari.quarkus.data.User;
import master.veille.nari.quarkus.service.MessageService;
import master.veille.nari.quarkus.service.UserService;

@Path("")
public class Ressource {
	private static final String USERS_PATH = "/users";
	private static final String USERNAME_PATH = USERS_PATH + "/{username}";
	private static final String MESSAGES_PATH = "/messages";
	private static final String USER_MESSAGES_PATH = USERNAME_PATH + MESSAGES_PATH;

	@Inject
	private MessageService messageService;

	@Inject
	private UserService userService;

	@GET
	@Path(USERS_PATH)
	public List<User> getUsers() {
		return userService.listAll();
	}

	@POST
	@Path(USERNAME_PATH)
	public User add(@RestPath String username) {
		return userService.newUser(username);
	}

	@GET
	@Path(MESSAGES_PATH)
	public List<Message> getAll() {
		return messageService.listAll();
	}

	@GET
	@Path(USER_MESSAGES_PATH)
	public List<Message> getMessages(@RestPath String username) {
		return messageService.listByUsername(username);
	}

	@POST
	@Path(USER_MESSAGES_PATH)
	public Message addMessage(@RestPath String username, @RestQuery String message) {
		return messageService.newMessage(username, message);
	}
}
