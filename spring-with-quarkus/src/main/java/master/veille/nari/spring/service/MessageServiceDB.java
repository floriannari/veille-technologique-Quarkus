package master.veille.nari.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import master.veille.nari.spring.model.Message;
import master.veille.nari.spring.model.User;
import master.veille.nari.spring.repo.MessageRepo;

@Service
@Transactional
public class MessageServiceDB implements MessageService {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageRepo messageRepo;

	@Override
	public Message newMessage(String username, String message) {
		User user = userService.findByUsername(username);
		return newMessage(user, message);
	}

	@Override
	public Message newMessage(User user, String message) {
		Message messageObj = new Message(user, message);
		return messageRepo.save(messageObj);
	}

	@Override
	public List<Message> listAll() {
		return messageRepo.findAllByOrderByDate();
	}

	@Override
	public List<Message> listByUsername(String username) {
		User user = userService.findByUsername(username);
		return listByUser(user);
	}

	@Override
	public List<Message> listByUser(User user) {
		return messageRepo.findAllByUserOrderByDate(user);
	}
}