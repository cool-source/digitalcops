package digitalcops.com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("digitalcops.com")
@EnableJpaRepositories(basePackages = "digitalcops.com.dao")
@EntityScan("digitalcops.com.entities")
public class DigitalcopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalcopsApplication.class, args);
	}

}