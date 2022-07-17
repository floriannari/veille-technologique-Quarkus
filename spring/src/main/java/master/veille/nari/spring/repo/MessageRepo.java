package master.veille.nari.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import master.veille.nari.spring.model.Message;
import master.veille.nari.spring.model.User;

public interface MessageRepo extends JpaRepository<Message, Long> {
	List<Message> findAllByUserOrderByDate(User user);

	List<Message> findAllByOrderByDate();
}
