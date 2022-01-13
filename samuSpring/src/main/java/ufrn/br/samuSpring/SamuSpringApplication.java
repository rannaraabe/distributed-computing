package ufrn.br.samuSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SamuSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamuSpringApplication.class, args);
	}
	
	// maven clean install
	// java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8000
}
