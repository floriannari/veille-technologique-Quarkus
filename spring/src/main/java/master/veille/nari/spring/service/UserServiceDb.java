package master.veille.nari.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import master.veille.nari.spring.model.User;
import master.veille.nari.spring.repo.UserRepo;

@Service
@Transactional
public class UserServiceDb implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> listAll() {
		return userRepo.findAllByOrderByUsername();
	}

	@Override
	public User newUser(String username) {
		User user = new User(username);
		return userRepo.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
}
