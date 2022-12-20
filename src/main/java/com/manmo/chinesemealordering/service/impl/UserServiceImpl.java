package com.manmo.chinesemealordering.service.impl;

import com.manmo.chinesemealordering.dto.UserRegisterDTO;
import com.manmo.chinesemealordering.entity.User;
import com.manmo.chinesemealordering.repository.UserRepository;
import com.manmo.chinesemealordering.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User register(UserRegisterDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }
}
