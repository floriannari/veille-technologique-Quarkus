package master.veille.nari.springnative.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import master.veille.nari.springnative.model.User;
import master.veille.nari.springnative.repo.UserRepo;

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
