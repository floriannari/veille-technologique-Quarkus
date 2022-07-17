package master.veille.nari.quarkus.service;

import java.util.List;

import master.veille.nari.quarkus.data.User;

public interface UserService {
	List<User> listAll();

	User newUser(String username);

	User findByUsername(String username);
}
