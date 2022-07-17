package master.veille.nari.quarkus.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import master.veille.nari.quarkus.data.User;

@ApplicationScoped
@Transactional
public class UserServiceDb implements UserService {

	@Override
	public List<User> listAll() {
		return User.listOrderbyUsername();
	}

	@Override
	public User newUser(String username) {
		User user = new User(username);
		user.persist();
		return user;
	}

	@Override
	public User findByUsername(String username) {
		return User.findByUsername(username);
	}
}
