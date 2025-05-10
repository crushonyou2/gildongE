package com.gildong.gildongE.service;

import com.gildong.gildongE.dto.DrivingPatternRequest;
import com.gildong.gildongE.dto.DrivingPatternResponse;
import com.gildong.gildongE.exception.ResourceNotFoundException;
import com.gildong.gildongE.model.DrivingPattern;
import com.gildong.gildongE.repository.DrivingPatternRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrivingPatternService {
    private final DrivingPatternRepository patternRepo;
    private final UserService userService;

    public DrivingPatternService(DrivingPatternRepository patternRepo,
                                 UserService userService) {
        this.patternRepo = patternRepo;
        this.userService = userService;
    }

    /** 운전 패턴 기록 저장 */
    public DrivingPatternResponse recordPattern(DrivingPatternRequest req) {
        // 사용자 존재 여부 확인
        userService.getUserById(req.getUserId());

        DrivingPattern e = new DrivingPattern();
        e.setUserId(req.getUserId());
        e.setDrivingScore(req.getDrivingScore());
        e.setRecordedAt(LocalDateTime.now());
        DrivingPattern saved = patternRepo.save(e);

        // 평균 점수 갱신
        userService.updateAvgScore(req.getUserId());

        return toResponse(saved);
    }

    /** 사용자별 모든 점수 조회 (평균 계산용) */
    public List<Float> getScoresByUserId(String userId) {
        // 사용자 존재 여부 확인
        userService.getUserById(userId);
        return patternRepo.findByUserId(userId)
                .stream()
                .map(DrivingPattern::getDrivingScore)
                .collect(Collectors.toList());
    }

    /** 사용자별 기록 전체 조회 */
    public List<DrivingPatternResponse> listPatterns(String userId) {
        // 사용자 존재 여부 확인
        userService.getUserById(userId);
        return patternRepo.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private DrivingPatternResponse toResponse(DrivingPattern e) {
        DrivingPatternResponse dto = new DrivingPatternResponse();
        dto.setId(e.getId());
        dto.setUserId(e.getUserId());
        dto.setDrivingScore(e.getDrivingScore());
        dto.setRecordedAt(e.getRecordedAt());
        return dto;
    }
}
