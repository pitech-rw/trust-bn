package pitech.trust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TrustApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
               dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(TrustApplication.class, args);
	}

}
