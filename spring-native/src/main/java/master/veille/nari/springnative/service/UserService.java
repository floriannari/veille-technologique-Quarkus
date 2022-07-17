package master.veille.nari.springnative.service;

import java.util.List;

import master.veille.nari.springnative.model.User;

public interface UserService {
	List<User> listAll();

	User newUser(String username);

	User findByUsername(String username);
}
