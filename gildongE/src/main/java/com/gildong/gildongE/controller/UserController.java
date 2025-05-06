package com.gildong.gildongE.controller;

import com.gildong.gildongE.dto.UserRegisterRequest;
import com.gildong.gildongE.dto.UserResponse;
import com.gildong.gildongE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRegisterRequest req) {
        UserResponse resp = userService.registerUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/{loginId}")
    public ResponseEntity<UserResponse> getUserByLoginId(@PathVariable String loginId) {
        UserResponse resp = userService.findByLoginId(loginId);
        if (resp != null) {
            return ResponseEntity.ok(resp);
        }
        return ResponseEntity.notFound().build();
    }
}
