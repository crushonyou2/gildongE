package com.gildong.gildongE.service;

import com.gildong.gildongE.dto.UserRegisterRequest;
import com.gildong.gildongE.dto.UserResponse;
import com.gildong.gildongE.model.User;
import com.gildong.gildongE.model.AuthProvider;
import com.gildong.gildongE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse registerUser(UserRegisterRequest dto) {
        // 1) DTO → Entity 변환
        User u = new User();
        u.setUserName(dto.getUserName());
        u.setLoginId(dto.getLoginId());
        u.setPassword(passwordEncoder.encode(dto.getPassword()));
        u.setProvider(dto.getProvider() == null ? AuthProvider.LOCAL : dto.getProvider());
        u.setCreatedAt(LocalDateTime.now());

        // 2) 저장
        User saved = userRepository.save(u);

        // 3) Entity → DTO 변환
        UserResponse resp = new UserResponse();
        resp.setId(saved.getId());
        resp.setUserName(saved.getUserName());
        resp.setLoginId(saved.getLoginId());
        resp.setProvider(saved.getProvider());
        resp.setCreatedAt(saved.getCreatedAt());
        return resp;
    }

    public UserResponse findByLoginId(String loginId) {
        User u = userRepository.findByLoginId(loginId);
        if (u == null) return null;

        UserResponse resp = new UserResponse();
        resp.setId(u.getId());
        resp.setUserName(u.getUserName());
        resp.setLoginId(u.getLoginId());
        resp.setProvider(u.getProvider());
        resp.setCreatedAt(u.getCreatedAt());
        return resp;
    }
}
