package com.manmo.chinesemealordering.api;

import com.manmo.chinesemealordering.entity.User;
import com.manmo.chinesemealordering.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class UserControllerApiTest extends SpringBootTestBaseTest{
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void should_return_user_given_username_and_password() {
        User mockUser = User.builder()
                .username("tom")
                .password("123")
                .mobile("13012345678")
                .build();
        userRepository.save(mockUser);

        ResponseEntity<User> responseEntity = restTemplate.getForEntity("/user/login?username=tom&password=123", User.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getHeaders().getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
        final var fetchedUser = responseEntity.getBody();
        assertThat(fetchedUser).isNotNull();
        assertThat(fetchedUser.getUsername()).isEqualTo(mockUser.getUsername());
        assertThat(fetchedUser.getPassword()).isEqualTo(mockUser.getPassword());
    }
}
