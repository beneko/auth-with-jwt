package com.sec.auth;

import com.sec.auth.entities.Role;
import com.sec.auth.entities.User;
import com.sec.auth.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AuthWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthWithJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AuthService authService) {
		return args -> {
			System.out.println("-----------------");
			authService.addRole(new Role(null, "USER"));
			authService.addRole(new Role(null, "ADMIN"));
			authService.addRole(new Role(null, "MANAGER"));
			authService.addRole(new Role(null, "SUPERVISOR"));
			authService.addRole(new Role(null, "OPERATOR"));


			authService.addUser(new User(null, "user", "1234", new ArrayList<>()));
			authService.addUser(new User(null, "admin", "1234", new ArrayList<>()));
			authService.addUser(new User(null, "manager", "1234", new ArrayList<>()));
			authService.addUser(new User(null, "supervisor", "1234", new ArrayList<>()));
			authService.addUser(new User(null, "operator", "1234", new ArrayList<>()));

			authService.addRoleToUser("user", "USER");

			authService.addRoleToUser("admin", "USER");
			authService.addRoleToUser("admin", "ADMIN");

			authService.addRoleToUser("manager", "MANAGER");
			authService.addRoleToUser("manager", "USER");

			authService.addRoleToUser("supervisor", "SUPERVISOR");
			authService.addRoleToUser("supervisor", "USER");

			authService.addRoleToUser("operator", "OPERATOR");
			authService.addRoleToUser("operator", "USER");

		};
	}

}
