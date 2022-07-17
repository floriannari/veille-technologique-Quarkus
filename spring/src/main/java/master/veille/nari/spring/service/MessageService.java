package master.veille.nari.spring.service;

import java.util.List;

import master.veille.nari.spring.model.Message;
import master.veille.nari.spring.model.User;

public interface MessageService {
	Message newMessage(String username, String message);

	Message newMessage(User user, String message);

	List<Message> listAll();

	List<Message> listByUsername(String username);

	List<Message> listByUser(User user);
}
