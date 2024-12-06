package com.mila.jwt.user;

import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public User toUser(UserDTO userDTO) {
        return User.builder()
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }

    public UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
