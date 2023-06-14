package com.familink.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//	public Application(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	private final UserRepository userRepository;
//
//	@Bean
//	public CommandLineRunner commandLineRunner(
//			AuthenticationService service
//	){
//		return args -> {
//			if (userRepository.existsByEmail("admin@gmail.com")) {
//				System.out.println("Admin user already exists");
//			} else {
//				var admin = RegisterRequest.builder()
//						.firstname("Admin")
//						.lastname("Admin")
//						.email("admin@gmail.com")
//						.password("12345678")
//						.role(ADMIN)
//						.build();
//				System.out.println("Admin token: " + service.register(admin).getAccessToken());
//			}
//			if (userRepository.existsByEmail("manager@gmail.com")) {
//				System.out.println("Manager user already exists");
//			} else {
//				var manager = RegisterRequest.builder()
//						.firstname("Manager")
//						.lastname("Manager")
//						.email("manager@gmail.com")
//						.password("12345678")
//						.role(MANAGER)
//						.build();
//				System.out.println("Manager token: " + service.register(manager).getAccessToken());
//			}
//		};
//	}

}
