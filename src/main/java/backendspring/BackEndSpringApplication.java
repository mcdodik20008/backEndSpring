package backendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class BackEndSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndSpringApplication.class, args);
    }
}