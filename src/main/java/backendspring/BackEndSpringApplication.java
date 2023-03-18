package backendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
@EnableAsync(proxyTargetClass = true)
public class BackEndSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndSpringApplication.class, args);
    }
}