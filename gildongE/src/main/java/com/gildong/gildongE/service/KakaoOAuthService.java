package com.gildong.gildongE.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gildong.gildongE.dto.UserResponse;
import com.gildong.gildongE.model.AuthProvider;
import com.gildong.gildongE.model.User;
import com.gildong.gildongE.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KakaoOAuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String clientId = "dba02cfce15347e2fc158f42700ad854";
    private final String redirectUri = "http://13.125.234.150:8080/api/auth/kakao/callback";

    public UserResponse kakaoLogin(String code) throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("code", code);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        String tokenResponse = restTemplate.postForObject("https://kauth.kakao.com/oauth/token", request, String.class);
        String accessToken = objectMapper.readTree(tokenResponse).get("access_token").asText();

        HttpHeaders userHeaders = new HttpHeaders();
        userHeaders.set("Authorization", "Bearer " + accessToken);
        HttpEntity<?> userRequest = new HttpEntity<>(userHeaders);

        String userInfoResponse = restTemplate.postForObject("https://kapi.kakao.com/v2/user/me", userRequest, String.class);
        JsonNode userJson = objectMapper.readTree(userInfoResponse);
        String email = userJson.get("kakao_account").get("email").asText();
        String nickname = userJson.get("properties").get("nickname").asText();

        Optional<User> existingUser = userRepository.findByLoginId(email);
        if (existingUser.isPresent()) {
            return userService.toResponse(existingUser.get());
        }

        User newUser = new User();
        newUser.setLoginId(email);
        newUser.setUserName(nickname);
        newUser.setPassword(null);
        newUser.setEmail(email);
        newUser.setProvider(AuthProvider.KAKAO);
        newUser.setCreatedAt(LocalDateTime.now());

        return userService.toResponse(userRepository.save(newUser));
    }
}
