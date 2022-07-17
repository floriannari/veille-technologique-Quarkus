package master.veille.nari.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import master.veille.nari.spring.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	List<User> findAllByOrderByUsername();
}
