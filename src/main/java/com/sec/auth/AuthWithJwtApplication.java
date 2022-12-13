package com.sec.auth;

import com.sec.auth.entities.AppRole;
import com.sec.auth.entities.AppUser;
import com.sec.auth.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
			authService.addAppRole(new AppRole(null, "USER"));
			authService.addAppRole(new AppRole(null, "ADMIN"));
			authService.addAppRole(new AppRole(null, "MANAGER"));
			authService.addAppRole(new AppRole(null, "SUPERVISOR"));
			authService.addAppRole(new AppRole(null, "OPERATOR"));


			authService.addAppUser(new AppUser(null, "user", "1234", new ArrayList<>()));
			authService.addAppUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
			authService.addAppUser(new AppUser(null, "manager", "1234", new ArrayList<>()));
			authService.addAppUser(new AppUser(null, "supervisor", "1234", new ArrayList<>()));
			authService.addAppUser(new AppUser(null, "operator", "1234", new ArrayList<>()));

			authService.addAppRoleToAppUser("user", "USER");

			authService.addAppRoleToAppUser("admin", "USER");
			authService.addAppRoleToAppUser("admin", "ADMIN");

			authService.addAppRoleToAppUser("manager", "MANAGER");
			authService.addAppRoleToAppUser("manager", "USER");

			authService.addAppRoleToAppUser("supervisor", "SUPERVISOR");
			authService.addAppRoleToAppUser("supervisor", "USER");

			authService.addAppRoleToAppUser("operator", "OPERATOR");
			authService.addAppRoleToAppUser("operator", "USER");

		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
