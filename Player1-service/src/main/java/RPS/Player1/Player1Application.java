package RPS.Player1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Game APIS", version="1.0", description = "Rock Paper Scissors Game"))
public class Player1Application {

	public static void main(String[] args) {
		SpringApplication.run(Player1Application.class, args);
	}

}
