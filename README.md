# GildongE — AI 차량 어시스턴트 백엔드

7인 팀으로 개발한 AI 차량 어시스턴트의 **Spring Boot·MongoDB 백엔드 저장소**입니다. 여러 장치와 앱에서 생성되는 차량·소모품·주행 데이터를 사용자 단위로 저장하고 조회할 수 있도록 도메인 API와 데이터 모델을 구현했습니다.

- 기간: 2025.03 ~ 2025.06
- 담당: 백엔드·데이터베이스
- 결과: 경기대학교 졸업 캡스톤 경연대회 은상, 2025 한국정보기술학회 하계 종합학술대회 논문 공저

![GildongE 프로젝트 포스터](gildongE_poster.jpg)

## 맡은 문제

졸음 감지 장치, 모바일 앱, 차량 관리 기능에서 서로 다른 형태의 데이터가 발생했습니다. 백엔드는 이를 차량·소모품·주행패턴 도메인으로 나누어 저장하고, 사용자별 기록을 일관된 REST API로 제공해야 했습니다.

## 구현 범위

| 영역 | 구현 내용 | 확인 위치 |
|---|---|---|
| 차량 | 차량·차종 등록, 조회, 수정, 삭제 | `controller/CarController`, `CarModelController` |
| 소모품 | 소모품 정보와 교체 예정일 관리 | `controller/ConsumableController` |
| 주행패턴 | 주행 점수 기록·조회, 사용자별 주간 평균 집계 | `DrivingPatternService`, `WeeklyAverageResponse` |
| 사용자 | 사용자 등록·조회·수정 | `UserController`, `UserService` |
| 카카오 로그인 | 인가 코드를 액세스 토큰으로 교환하고 카카오 사용자를 조회·등록 | `KakaoOAuthService`, `AuthController` |
| API 문서 | 주요 요청·응답 스키마와 오류 응답 정리 | `src/main/resources/static/openapi.yaml` |

## 역할 경계

전체 팀 시스템에는 졸음 감지와 차량 매뉴얼 기반 RAG 질의응답 컴포넌트가 포함됐습니다. **RAG 모델과 검색 파이프라인은 팀의 별도 컴포넌트이며 이 저장소에는 포함되지 않습니다.** 이 저장소가 증명하는 제 기여 범위는 차량 도메인 백엔드와 MongoDB 모델, 사용자·카카오 로그인 흐름, 주행 데이터 집계입니다.

현재 프로토타입은 카카오 사용자 조회·등록 흐름까지 구현돼 있지만 JWT를 발급하지 않으며, `SecurityConfig`의 API 접근 제어도 전체 허용 상태입니다. 운영 환경이라면 토큰 기반 인증과 사용자별 인가 정책을 추가해야 합니다.

## 기술 선택

- **Spring Boot / Java 17**: 도메인별 REST API 구성
- **MongoDB**: 장치와 기능별로 형태가 달라질 수 있는 차량 데이터 수용
- **Spring Data MongoDB**: Repository 기반 데이터 접근
- **Kakao OAuth API**: 인가 코드 기반 사용자 확인
- **OpenAPI 3.0**: API 요청·응답 계약 문서화

## 실행

필수 환경변수:

```text
MONGODB_URI=mongodb+srv://...
KAKAO_CLIENT_ID=...
KAKAO_REDIRECT_URI=http://localhost:8080/api/auth/kakao/callback
```

실행 명령:

```bash
cd gildongE
./gradlew bootRun
```

API 문서는 `gildongE/src/main/resources/static/openapi.yaml`에서 확인할 수 있습니다.

## 개발자

**Jigwan Joe — Backend Developer**

- GitHub: https://github.com/crushonyou2
- Email: jigwan.joe@gmail.com
