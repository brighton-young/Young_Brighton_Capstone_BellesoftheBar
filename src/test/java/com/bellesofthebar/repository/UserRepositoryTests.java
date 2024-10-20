package com.bellesofthebar.repository;

import com.bellesofthebar.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("user@example.com");
        user.setPassword("password123");
        user.setRole(User.Role.USER);
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByUsername("testuser");

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("testuser");
    }

    @Test
    public void testFindByEmail() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("user@example.com");
        user.setPassword("password123");
        user.setRole(User.Role.USER);
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByEmail("user@example.com");

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("user@example.com");
    }

    @Test
    public void testSaveAndRetrieve() {
        // Given
        User user = new User();
        user.setUsername("newuser");
        user.setEmail("newuser@example.com");
        user.setPassword("newpassword");
        user.setRole(User.Role.ADMIN);
        userRepository.save(user);

        // When
        User foundUser = userRepository.findById(user.getId()).orElse(null);

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("newuser");
        assertThat(foundUser.getRole()).isEqualTo(User.Role.ADMIN);
    }
}