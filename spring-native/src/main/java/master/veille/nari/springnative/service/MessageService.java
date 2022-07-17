package master.veille.nari.springnative.service;

import java.util.List;

import master.veille.nari.springnative.model.Message;
import master.veille.nari.springnative.model.User;

public interface MessageService {
	Message newMessage(String username, String message);

	Message newMessage(User user, String message);

	List<Message> listAll();

	List<Message> listByUsername(String username);

	List<Message> listByUser(User user);
}
