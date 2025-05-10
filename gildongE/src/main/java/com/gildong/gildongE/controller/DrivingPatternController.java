package com.gildong.gildongE.controller;

import com.gildong.gildongE.dto.DrivingPatternRequest;
import com.gildong.gildongE.dto.DrivingPatternResponse;
import com.gildong.gildongE.service.DrivingPatternService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patterns")
public class DrivingPatternController {
    private final DrivingPatternService patternService;

    public DrivingPatternController(DrivingPatternService patternService) {
        this.patternService = patternService;
    }

    /** 운전 점수 기록 */
    @PostMapping
    public ResponseEntity<DrivingPatternResponse> record(
            @RequestBody DrivingPatternRequest req) {
        DrivingPatternResponse resp = patternService.recordPattern(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    /** 사용자별 운전 기록 조회 */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DrivingPatternResponse>> listByUser(
            @PathVariable String userId) {
        List<DrivingPatternResponse> list = patternService.listPatterns(userId);
        return ResponseEntity.ok(list);
    }
}
