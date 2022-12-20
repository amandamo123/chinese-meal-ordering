package com.manmo.chinesemealordering.service.impl;

import com.manmo.chinesemealordering.dto.UserRegisterDTO;
import com.manmo.chinesemealordering.entity.User;
import com.manmo.chinesemealordering.exception.UsernameOrPasswordErrorException;
import com.manmo.chinesemealordering.repository.UserRepository;
import com.manmo.chinesemealordering.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private HttpSession session;

    @Override
    public User register(UserRegisterDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameOrPasswordErrorException("Username Not Correct"));
        if (!user.getPassword().equals(password)) {
            throw new UsernameOrPasswordErrorException("Password Not Correct");
        }
        session.setAttribute("user", user);
        return user;
    }
}
