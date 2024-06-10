package com.montrack_jpa.montract_jpa.user;

import com.montrack_jpa.montract_jpa.user.entity.User;
import com.montrack_jpa.montract_jpa.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public void createdUser(@RequestBody User user){
        userService.createdUser(user);
    }
}
