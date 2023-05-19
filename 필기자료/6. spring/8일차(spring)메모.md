# 스프링 프레임워크
## 스프링 웹 MVC
### 1.커맨드 객체 검증
    - Validator 인터페이스
        - suports(...) : 커맨드 객체 제한(특정 커맨드만 검증가능하게 함)
        - validate(...) : 실제 검증기능
    - Errors 객체
        - 커맨드 객체 자체 오류,예외 발생
            - reject(String code);
            - reject(String code, String defaultMessage);
                - defaultMessage -> 메세지파일에 정의된 code가 없으면 출력
        - 특정 필드에 해당하는 오류,예외 발생
            - rejectValue(String field, String code);
            - rejectValue(String field, String code, String defaultMessage);
        - 메세지코드의 적용 범위 지정
            - 메세지코드.필드명
            - 메세지코드.커맨드객체.필드명
            - 메세지코드.자료형
            - 메세지코드.필드명.자료형
            - 메세지코드.커맨드객체.자료형
        - ValidationUtils클래스
            - rejectIfEmpty(Errors errors, String code, String defaultMessage);
            - rejectIfEmptyOrWhitespace(Errors errors, String code, String defaultMessage);
        - Bean Validation API (자바 표준 - javax.validation 패키지)
            - 구현체 : hibernate validator
            - 의존성 주입
                - 메이븐 레포지터리 -> Bean Validation API 2.0.1.Final 의존성 주입
                - 메이븐 레포지터리 -> Hibernate Validator Engine » 6.0.23.Final 의존성 주입
            - @Valid 커맨드객체
                - 에너테이션으로 검증 진행
                - 에너테이션명.필드명으로 메세지파일의 내용 불러오기 가능
    - @RequiredArgsConstructor : 반드시 값이 있어야 하는 멤버 변수를 생성자 매개변수로 자동 추가
        - (final, @NonNull)을 멤버변수에 적용하면 된다.
    - 암호화
        - 양방향 암호화 : 암호화 <-> 복호화
        - 단방향 암호화 : 암호화/ 복호화 불가 -> 해시
            - 해시
                - 고정 해시 : 같은 값에 같은 해시값이 나옴 -> md5, sha256, sha512 ...
                - 유동 해시 : 같은 값에 매번 다른 해시값이 나옴 -> bcrypt
        - 의존성 설정
            - 메이븐 센트럴 -> jbcrypt 0.4 의존성 복사 후 pom.xml에 입력
### 2.세션, 인터셉터, 쿠키
    - 서블릿 핵심 객체 : 편의상 스프링 관리 객체가 추가되어 있다.(의존성 자입주입이 가능하다.)
        - HttpServletRequest, HttpServletResponse, HttpSession ...
        - 요청메서드에 주입, @Autowired 으로 사용
    - @CookieValue : 원하는 쿠키를 찾아서 자동으로 주입

### 3.날짜 값 변환
### 4.@PathVariable
### 5.컨트롤러 예외처리
### 6.파일업로드
### 7.프로필
    - @Prifile
    - spring.profiles.active
### 8.프로퍼티 파일
    - PropertySourcePlaceholderConfigurer
