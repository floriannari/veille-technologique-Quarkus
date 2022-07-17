package master.veille.nari.spring.service;

import java.util.List;

import master.veille.nari.spring.model.User;

public interface UserService {
	List<User> listAll();

	User newUser(String username);

	User findByUsername(String username);
}
