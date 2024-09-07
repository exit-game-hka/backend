package com.hka.exitgame;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		servers = {
				@Server(url = "https://193.196.37.101/exit-game-backend", description = "Default Server URL")
		}
)
@SpringBootApplication
public class ExitGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExitGameApplication.class, args);
	}

}
