# 스프링 프레임워크
## 타임리프(thymeleaf)
### 타임리프 페이지 레이아웃 설정
    - Thymeleaf Layout Dialect 의존성 주입
    - html태그에 속성 주입
        - xmlns:th="http://www.thymeleaf.org"
        - xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"  - 페이지 레이아웃 기능
    - 정적자원 경로 추가 : MvcConfig에 정의  
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/static/");
        }
### 타임리프 페이지 레이아웃 기능
    - thymeleaf layout
    - th:replace -> th:fragment에 등록 된 템플릿 파일을 가져오기
    - th:fragment="" -> 해당 태그를 다른 파일에서 가져다 사용가능
    - layout:decorate="~{경로}" -> 경로에 있는 fragment 가져올 수 있게 설정
    - 특정 페이지에 css,js파일 추가하는 법
        <link th:each="cssFile : ${addCss}" type="text/css" th:href="@{/css/{file}.css(file=${cssFile})}">
        <script th:each="jsFile : ${addScript}" th:src="@{/js/{file}.js(file=${jsFile})}"></script>
        - Controller에 addCss, addScript 추가하고 model로 속성화

## 스프링 웹 MVC
### 1.커맨드 객체
    - 요청 데이터(쿼리스트링)를 객체에 자동으로 매핑
    - @ModelAttribute - 커맨드객체로 지정, 커맨드객체의 이름(EL식)
    - th:field : HTML태그에 맞게 값이 있으면 양식 데이터를 자동완성
### 2.리다이렉트
    - return "redirect:경로" : Mapping 에너테이션 메서드의 리턴값으로 주면 해당경로로 이동 기능
### 4.모델(Model model)
    - 커맨드 객체의 일종, 객체를 속성으로 적용하는 기능이 있다.
### 5.메시지
    - 다국어 설정용 메시지파일 관리, MvcConfig클래스에 MessageSource를 재정의하여 메시지파일의 경로 지정 후 사용
    - #{메시지코드} 형태로 사용 가능
### 6.커맨드 객체 검증하기
    - Validator 인터페이스
    - Errors 에러객체 : 요청 메서드에 주입
        -> 템플릿과 연동되어 있음
        - rejectValue(...) : 특정 필드에 한정한 오류가 저장
        - reject(...) : 커맨드 객체 전체에 한정한 오류가 저장
        - boolean hasErrors() : 모든 검증에서 1개라도 에러가 나면 true
### 7.세션, 쿠키, 인터셉터

### 웹Mvc와 데이터베이스 연결 설정
    - Spring jdbc + Tomcat jdbc + ojdbc8 의존성 주입(jdbc용)
    - Slf4j-api + lodgback-classic 의존성 주입(로그추적용)
    - DataSource설정 - Mvc설정클래스
    - jdbcTemplate설정 - Mvc설정클래스
    - PlatFormTransactionManager설정 - Mvc설정클래스 : @Transactional 사용 가능
