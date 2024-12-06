package com.mila.jwt.user;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDTO {

    private UUID uuid;
    private String email;
    private String password;

}
