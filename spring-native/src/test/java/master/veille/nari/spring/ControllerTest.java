package master.veille.nari.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import master.veille.nari.springnative.Application;

@SpringBootTest(classes = Application.class)
@AutoConfigureWebTestClient
public class ControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void test() throws Exception {
		webTestClient //
				.get().uri("/users") //
				.exchange() //
				.expectStatus().isOk();
	}
}
