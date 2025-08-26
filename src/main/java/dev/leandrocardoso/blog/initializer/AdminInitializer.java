package dev.leandrocardoso.blog.initializer;

import dev.leandrocardoso.blog.model.User;
import dev.leandrocardoso.blog.repository.UserRepository;
import dev.leandrocardoso.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@Slf4j
public class AdminInitializer {

    @Bean
    public CommandLineRunner initAdminUser(
            UserRepository userRepository,
            UserService userService
    ) {

        return args -> {

            Optional<User> adminOptional = userRepository.findByUsername("admin");

            if (adminOptional.isEmpty()) {

                User adminUser = new User();
                adminUser.setUsername("admin");
                adminUser.setPassword("25101988");
                adminUser.setRole("ROLE_ADMIN");

                userService.registerUser(adminUser);

                log.info(
                        "Admin user '{}' created successfully.",
                        adminUser.getUsername()
                );

            }
            else {

                log.info("Admin user already exists.");

            }

        };

    }

}
