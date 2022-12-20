package com.manmo.chinesemealordering.service;

import com.manmo.chinesemealordering.dto.UserRegisterDTO;
import com.manmo.chinesemealordering.entity.User;

public interface UserService {
    User register(UserRegisterDTO user);

}
