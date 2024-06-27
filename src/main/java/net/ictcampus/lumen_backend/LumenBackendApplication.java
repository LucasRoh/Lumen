package net.ictcampus.lumen_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class LumenBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LumenBackendApplication.class, args);
	}

}
