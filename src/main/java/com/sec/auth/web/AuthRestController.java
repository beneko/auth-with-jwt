package com.sec.auth.web;

import com.sec.auth.entities.AppUser;
import com.sec.auth.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthRestController {

    private AuthService authService;

    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return authService.getAppUsers();
    }

}
