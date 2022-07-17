package master.veille.nari.springnative.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import master.veille.nari.springnative.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	List<User> findAllByOrderByUsername();
}
