package master.veille.nari.springnative.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import master.veille.nari.springnative.model.Message;
import master.veille.nari.springnative.model.User;

public interface MessageRepo extends JpaRepository<Message, Long> {
	List<Message> findAllByUserOrderByDate(User user);

	List<Message> findAllByOrderByDate();
}
