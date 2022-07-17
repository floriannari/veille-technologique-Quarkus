package master.veille.nari.spring;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import master.veille.nari.springnative.Application;
import master.veille.nari.springnative.model.Message;
import master.veille.nari.springnative.model.User;
import master.veille.nari.springnative.service.MessageService;
import master.veille.nari.springnative.service.UserService;

@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
class ServiceTest {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		User u1 = userService.newUser("u1");
		User u2 = userService.newUser("u2");

		Message m1 = messageService.newMessage("u1", "m1");
		Message m2= messageService.newMessage("u2", "m2");
		Message m3 = messageService.newMessage("u1", "m3");
		Message m4 = messageService.newMessage("u2", "m4");
		Message m5 = messageService.newMessage("u2", "m5");
		
		assertThat(userService.findByUsername("u1")).isEqualTo(u1);
		assertThat(userService.findByUsername("u2")).isEqualTo(u2);
		assertThat(userService.listAll()).containsExactly(u1, u2);
		
		assertThat(messageService.listByUsername("u1")).containsExactly(m1, m3);
		assertThat(messageService.listByUsername("u2")).containsExactly(m2, m4, m5);
		assertThat(messageService.listAll()).containsExactly(m1, m2, m3, m4, m5);
	}

}
