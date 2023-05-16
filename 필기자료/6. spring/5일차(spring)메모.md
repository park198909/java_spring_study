# 스프링 프레임워크
## 스프링 웹 MVC
### 1.스프링 MVC 시작하기
    - spring-webmvc 의존성
    - servlet-api 의존성
    - servlet.jsp-api 의존성

### 2.스프링 MVC 설정
    - WebMvcConfigurer 인터페이스를 설정클래스에 상속
        - 기본설정과 달라야 하는 부분을 정의하기위한 인터페이스
    - MVC설정클래스에 @EnableWebMvc 적용
        - 웹MVC 기본설정을 자동으로 적용(프록시 형태로 적용)
    - web.xml 설정
      <?xml version="1.0" encoding="UTF-8"?>
      <web-app version="4.0" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee                       http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">
      <servlet>
      <servlet-name>dispatcher</servlet-name>
      <servlet-class>
      org.springframework.web.servlet.DispatcherServlet
      </servlet-class>
      <init-param>
      <param-name>contextClass</param-name>
      <param-value>
      org.springframework.web.context.support.AnnotationConfigWebApplicationContext
      </param-value>
      </init-param>
      <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>
      configs.MvcConfig
      configs.ControllerConfig
      </param-value>
      </init-param>
      <load-on-startup>1</load-on-startup>
      </servlet>
      <servlet-mapping>
          <servlet-name>dispatcher</servlet-name>
          <url-pattern>/</url-pattern>
      </servlet-mapping>
      <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>
            org.springframework.web.filter.CharacterEncodingFilter
        </filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>UTF-8</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>encodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
        </web-app>
### 3.스프링 MVC 진행 과정
    - DispatcherServlet
        - 요청~응답 까지 모든 과정을 총괄하여 관리
    - HandlerMapping
        - 요청을 처리 가능한 Controller 빈을 탐색하여 반환
        - Controller 빈의 종류
            - @Controller
            - Controller 인터페이스
            - HttpRequestHandler 인터페이스
    - HandlerAdapter
        - Controller 빈의 종류를 하나로 통일시켜 전달
        - 처리결과를 ModelAndView 형태로 반환
        - ModelAndView : 결과데이터(model) + 템플릿경로(view)
    - ViewResolver
        - ModelAndView를 토대로 출력할 view객체를 찾아서 반환
        - DispatcherServlet이 받아서 응답처리완료
### 4.요청 방식에 따른 설정
    - GET요청
        - @GetMapping
    - DELETE요청
        - @DeleteMapping
    - POST요청
        - @PostMapping
    - PUT요청
        - @PutMapping
    - PATCH요청
        - @PatchMapping
    - 모든 요청(예전 방식)
        - @RequestMapping
            - 요청방식에 무관한 공통적인 URL을 묶어서 처리할 때 사용
            - 다른 요청방식의 공통적인 부분을 빼서 적용 가능
            - 클래스에 적용해서 메서드의 요청방식에서 공통적인 URL을 입력
            - 다른 요청방식에서는 공통부분을 제외하고 URL입력 가능
### 5.커맨드 객체
    - 요청바디데이터를 저장할 수 있는 객체
        - 객체를 생성하여 @PostMapping 메서드에 매개변수로 입력
        - 객체의 변수명은 요청데이터의 name값과 동일하게 생성
    - Model model : 기본 생성되어 있는 커맨드 객체
        - addAttribute(String key, Object value) 기능 보유
            - EL 속성으로 자동 추가 : 클래스명 앞글자만 소문자로 변경
        - model.addAttribute("객체명", 객체명)
            - 객체를 "객체명"으로 속성으로 변환
            - 객체의 값을 속성으로 사용가능 : ${객체명.변수명}
    - 서블릿 기본 필수 객체를 스프링 관리객체로 등록하는 법
        1) 요청을 처리하는 메서드에 주입
        2) @Autowired
        3) 서블릿 기본 필수 객체
            - HttpServletRequest
            - HttpServletResponse
## 타임리프(thymeleaf)
### 1.스프링 MVC와 타임리프 연동 설정
    - thymeleaf-spring5 의존성 주입
    - thymeleaf-extras-java8time 의존성 주입
### 2.타임리프 소개
    - thymeleaf-spring5
    - thymeleaf-extras-java8time 
        - 식 객체(#temporals)