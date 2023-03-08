package appsfactory.keycloak.auth.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("appsfactory.keycloak.auth")
@EnableJpaRepositories("appsfactory.keycloak.auth")
@EntityScan("appsfactory.keycloak.auth")
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }

}
