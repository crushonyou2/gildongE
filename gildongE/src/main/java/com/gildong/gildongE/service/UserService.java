package com.gildong.gildongE.service;

import com.gildong.gildongE.dto.UserCreateRequest;
import com.gildong.gildongE.dto.UserResponse;
import com.gildong.gildongE.dto.UserUpdateRequest;
import com.gildong.gildongE.exception.ResourceNotFoundException;
import com.gildong.gildongE.model.DrivingPattern;
import com.gildong.gildongE.model.User;
import com.gildong.gildongE.repository.DrivingPatternRepository;
import com.gildong.gildongE.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final DrivingPatternRepository patternRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo,
                       DrivingPatternRepository patternRepo,
                       PasswordEncoder passwordEncoder) {
        this.userRepo    = userRepo;
        this.patternRepo = patternRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /** 신규 사용자 생성 */
    public UserResponse createUser(UserCreateRequest req) {
        User u = new User();
        u.setLoginId(req.getLoginId());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setUserName(req.getUserName());
        u.setAvgDrivingScore(0f);
        u.setCreatedAt(LocalDateTime.now());
        User saved = userRepo.save(u);
        return toResponse(saved);
    }

    /** 사용자 프로필 조회 */
    public UserResponse getUserById(String userId) {
        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        return toResponse(u);
    }

    /** 로그인용 조회 */
    public User getByLoginId(String loginId) {
        return userRepo.findByLoginId(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("User", loginId));
    }

    /** 사용자 이름/비밀번호 수정 */
    public UserResponse updateUser(String userId, UserUpdateRequest req) {
        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        u.setUserName(req.getUserName());
        if (req.getPassword() != null) {
            u.setPassword(passwordEncoder.encode(req.getPassword()));
        }
        User saved = userRepo.save(u);
        return toResponse(saved);
    }

    /** 평균 운전점수 재계산 후 업데이트 */
    public void updateAvgScore(String userId) {
        List<Float> scores = patternRepo.findByUserId(userId)
                .stream()
                .map(DrivingPattern::getDrivingScore)
                .collect(Collectors.toList());

        float avg = (float) scores.stream()
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);

        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));
        u.setAvgDrivingScore(avg);
        userRepo.save(u);
    }

    private UserResponse toResponse(User u) {
        UserResponse dto = new UserResponse();
        dto.setId(u.getId());
        dto.setLoginId(u.getLoginId());
        dto.setUserName(u.getUserName());
        dto.setAvgDrivingScore(u.getAvgDrivingScore());
        dto.setCreatedAt(u.getCreatedAt());
        return dto;
    }
}
