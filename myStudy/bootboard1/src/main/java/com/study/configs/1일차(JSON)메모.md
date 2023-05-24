# JSON
## JSON 응답과 요청 처리
### 1. JSON이란?
    - JSON(JavaScript Object Notation) : 자바스크립트 객체 표기법
    {"키" : "값", "키" : "값", "키" : "값"}
    - 타 플랫폼 간의 정보를 주고 받는데 사용됨(카카오 아이디로 로그인, 네이버 아이디로 로그인)
### 2. Jackson 의존 설정
    - 메이븐 레포지터리 - Jackson-databind 의존성 설정
    - 메이븐 레포지터리 - Jackson Datatype:JSR310 의존성 설정
    - Jackson의 역할
        - 자바 객체->JSON 문자열 변환
        - JSON 문자열->자바 객체 변환
### 3. @RestController
    - JSON으로 응답, 요청을 받을 수 있는 컨트롤러
    - 응답 헤더의 Content-type을 application/json으로 변환
    - 문자열만 반환하면 Content-type이 text/plain이 된다.
### 4. @ResponseBody 
    - 일반 컨트롤러에서 JSON으로 응답할 때 사용 
### 5. @JsonIgnore
    - JSON으로 변환하지 않게 함 - 출력 화면에서 제외
### 6. @JsonFormat
    - 날짜, 시간의 형식을 변경(응답, 요청)
### ARC(Advanced Rest Client) 모듈
    - 임의의 정보를 요청/응답에 실어 보내고 요청/응답상태를 확인하는 에디터
### 7. @RequestBody
    - 요청 데이터의 형식을 application/json 으로 지정하는 기능
### 8. ResponseEntity 클래스
    - 응답 상태 코드 | 응답 바디 데이터를 상세하게 통제
        - 자주 사용하는 응답 코드는 메서드로 정의되어 있다.
            - accepted() : 202
            - created(URI...) : 201
            - badRequest() : 401
            - internalServerError() : 500
            - noContent() : 204
            - notFound() : 404
            - ok() : 200, 응답 바디 없음
            - ok(T body) : 200, 응답 바디 있음 
    - 사용법
        - static status(...) : 응답 상태 코드에 입력
            - HttpStatus : 응답 코드를 Enum상수로 정의되어 있음
        - body(T body) : 응답 바디 데이터에 입력
        - build() : 응답 바디가 없는 경우 사용
### 9. @ExceptionHandler
    - 에러든 성공이든 데이터 응답의 통일성 확보하기 위해 사용
    - JSONResult클래스를 만들어 변수를 저장해 사용 : 지네릭스를 사용하는 것이 좋다.
    - @RestControllerAdvice에 정의된다.
### Jackson Databind
    - ObjectMapper
        - readValue(...) : JSON문자열 -> Java객체로 변환
            - Java DTO 객체로 변환한다.
        - writeValueAsString(...) : Java객체 -> JSON문자열로 변환

# 빌더 패턴
    - getter와 setter를 대신할 수 있는 패턴
    - 객체를 직접 생성하지 않는다.
        - 생성자 접근 제어자가 private로 고정
    - 사용법
         public static Builder builder() {
            return new Builder();
        }
        public static class Builder {
            private Board2 instance = new Board2();

            public Builder id(Long id) {
                instance.id = id;

                return this;
            }

            public Builder subject(String subject) {
                instance.subject = subject;

                return this;
            }

            public Builder content(String contnet) {
                instance.content = contnet;

                return this;
            }

            public Board2 build() {
                return instance;
            }
        }
    
# Spring Data JPA
## JPA란?
    - JPA
    - ORM(Object Relational Mapping)
        - 데이터베이스와 객체의 관계를 매핑해주는 기능
        - 데이터베이스의 종류를 알려줘야 한다.





# 조별 포트폴리오 제작
## Git Mind 활용
## 프로젝트 주제 결정 회의
## 프로젝트 기획서 작성

# 6월 7일 최종시험
## 1. 인터페이스 명세서 사전 작성
## 2. TDD를 통해 구현