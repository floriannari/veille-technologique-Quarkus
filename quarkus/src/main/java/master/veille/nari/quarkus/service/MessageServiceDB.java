package master.veille.nari.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import master.veille.nari.quarkus.data.Message;
import master.veille.nari.quarkus.data.User;

@ApplicationScoped
@Transactional
public class MessageServiceDB implements MessageService {

	@Inject
	private UserService userService;

	@Override
	public Message newMessage(String username, String message) {
		User user = userService.findByUsername(username);
		return newMessage(user, message);
	}

	@Override
	public Message newMessage(User user, String message) {
		Message messageObj = new Message(user, message);
		messageObj.persist();
		return messageObj;
	}

	@Override
	public List<Message> listAll() {
		return Message.listOrderedByDate();
	}

	@Override
	public List<Message> listByUsername(String username) {
		User user = userService.findByUsername(username);
		return listByUser(user);
	}

	@Override
	public List<Message> listByUser(User user) {
		return Message.listByUser(user);
	}
}
