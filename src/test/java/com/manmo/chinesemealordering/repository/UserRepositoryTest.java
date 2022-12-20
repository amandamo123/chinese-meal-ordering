package com.manmo.chinesemealordering.repository;

import com.manmo.chinesemealordering.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void should_return_login_user() {
        User mockUser = User.builder()
                .username("tom")
                .password("123")
                .mobile("13012345678")
                .build();
        entityManager.persist(mockUser);

        User foundUser = userRepository.findByUsername("tom");

        assertThat(foundUser.getUsername())
                .isEqualTo("tom");
        assertThat(foundUser.getPassword())
                .isEqualTo("123");
        assertThat(foundUser.getMobile())
                .isEqualTo("13012345678");

    }
}
