package com.springcloud.userservice.controller;

import com.springcloud.userservice.dto.User;
import com.springcloud.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userService.userList());
    }
}
