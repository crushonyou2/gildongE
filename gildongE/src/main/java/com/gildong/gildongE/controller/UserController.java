package com.gildong.gildongE.controller;

import com.gildong.gildongE.dto.UserCreateRequest;
import com.gildong.gildongE.dto.UserUpdateRequest;
import com.gildong.gildongE.dto.UserResponse;
import com.gildong.gildongE.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** 신규 사용자 생성 */
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest req) {
        UserResponse resp = userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    /** 사용자 프로필 조회 */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId) {
        UserResponse resp = userService.getUserById(userId);
        return ResponseEntity.ok(resp);
    }

    /** 사용자 이름 수정 */
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable String userId,
            @RequestBody UserUpdateRequest req) {
        UserResponse resp = userService.updateUser(userId, req);
        return ResponseEntity.ok(resp);
    }
}
