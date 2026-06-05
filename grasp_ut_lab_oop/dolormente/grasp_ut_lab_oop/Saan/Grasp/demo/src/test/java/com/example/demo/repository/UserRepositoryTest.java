    package com.example.demo.repository;

    import com.example.demo.entity.Users;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

    import java.util.List;
    import java.util.Optional;

    import static org.assertj.core.api.Assertions.assertThat;

    @DataJpaTest
    class UserRepositoryTest {

        @Autowired
        UserRepository userRepository;

        Users fakeUser;

        @BeforeEach
        void setUp() {
            fakeUser = new Users();
            fakeUser.setName("Maria");
            fakeUser.setProgram("BSIT");
            userRepository.save(fakeUser);
        }

        @Test
        void shouldSaveUser() {
            // Arrange
            Users newUser = new Users();
            newUser.setName("John");
            newUser.setProgram("BSCS");

            // Act
            Users saved = userRepository.save(newUser);

            // Assert
            assertThat(saved.getId()).isNotNull();
            assertThat(saved.getName()).isEqualTo("John");
        }

        @Test
        void shouldFindAllUsers() {
            // Arrange - already done in setUp()

            // Act
            List<Users> users = userRepository.findAll();

            // Assert
            assertThat(users).isNotEmpty();
            assertThat(users).hasSize(1);
        }

        @Test
        void shouldFindUserById() {
            // Arrange
            Long id = fakeUser.getId();

            // Act
            Optional<Users> found = userRepository.findById(id);

            // Assert
            assertThat(found).isPresent();
            assertThat(found.get().getName()).isEqualTo("Maria");
        }

        @Test
        void shouldDeleteUser() {
            // Arrange
            Long id = fakeUser.getId();

            // Act
            userRepository.deleteById(id);

            // Assert
            Optional<Users> deleted = userRepository.findById(id);
            assertThat(deleted).isEmpty();
        }

        @Test
        void shouldUpdateUser() {
            // Arrange
            fakeUser.setName("Maria Updated");

            // Act
            Users updated = userRepository.save(fakeUser);

            // Assert
            assertThat(updated.getName()).isEqualTo("Maria Updated");
        }
    }