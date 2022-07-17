package master.veille.nari.quarkus.service;

import java.util.List;

import master.veille.nari.quarkus.data.Message;
import master.veille.nari.quarkus.data.User;

public interface MessageService {
	Message newMessage(String username, String message);

	Message newMessage(User user, String message);

	List<Message> listAll();

	List<Message> listByUsername(String username);

	List<Message> listByUser(User user);
}
