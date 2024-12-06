package com.mila.jwt.login;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public LoginResponseDTO login(@RequestBody LoginDTO loginDTO){
        return loginService.authenticateUser(loginDTO);
    }

}
