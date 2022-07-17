package master.veille.nari.springnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import master.veille.nari.springnative.model.Message;
import master.veille.nari.springnative.repo.MessageRepo;
import master.veille.nari.springnative.service.MessageServiceDB;

@EnableJpaRepositories(basePackageClasses = MessageRepo.class)
@EntityScan(basePackageClasses = Message.class)
@ComponentScan(basePackageClasses = { Controller.class, MessageServiceDB.class })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
