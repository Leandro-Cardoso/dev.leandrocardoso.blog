package dev.leandrocardoso.blog.service;

import dev.leandrocardoso.blog.model.User;
import dev.leandrocardoso.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
            ) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public User registerUser(User user) {

        String encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        if (user.getRole() == null || user.getRole().isEmpty()) {

            user.setRole("ROLE_USER");

        }

        return userRepository.save(user);

    }

}
