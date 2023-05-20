# 스프링 프레임워크
## 스프링 웹 MVC
### 1.인터셉터
    - 시점 별 공통기능 구현
    - HandlerInterseptor 인터페이스
        - 주요메서드
            - boolean preHandle(...)
                - 요청 처리(handlerMapping후) 전 공통 기능 
                - 통제 및 제어
                    - 반환값이 false면 컨트롤러 빈, 요청메서드 실행 X
                    - 반환값이 true면 컨트롤러 빈, 요청메서드 실행
            - void postHandle(...)
                - 요청 처리 후 ModelAndView 반환 직후 공통기능
            - void afterCompletion(...)
                - 응답 완료 후 공통기능
        - 인터페이스 설정
            - WebMvcConfigurer의 addInterceptors(...)에서 설정
### 2.날짜값 변환
    - 커맨드객체의 날짜를 문자열로 변환
    - 날짜 형식 명시
        - @DateTimeFormat 에너테이션으로 형식 변경
            - pattern="패턴" 
    - typeMismatch 메세지코드 : 형식 검증 실패시 메세지 설정
### 3.@PathVariable
    - 경로 변수 : 변수를 URL경로로 사용 가능하게 설정
    - URL에 설정시 /{경로변수}가 @PathVariable변수에 저장됨
### 4.컨트롤러 예외처리
    - @ExceptionHandler(...) : 에러페이지 설정
        - 발생할지 모르는 예외클래스(~Exception.class)
        - 에러페이지에 대한 설정
    - 예외 조치 메서드에 주입가능한 객체
        - 발생한 예외 객체
        - 서블릿 기본 객체
            - HttpServletRequest,HttpServletResponse,HttpSession...\
        - Model model
    - @ControllerAdvice : 공통 컨트롤러로 지정
        - 범위를 지정하지 않으면 전체범위가 대상이 되므로 지정하는게 좋다.
    - 적용 우선순위
        - @Controller > @ControllerAdvice
### 5.파일업로드
    - Multipart 인터페이스
        - 
    - 설정 : 파일 1개의 최대용량, 전체 최대용량 설정
        - web.xml의 servlet에 설정입력
        <multipart-config>
            <max-file-size>20971520</max-file-size>         <!-- 파일 1개당 최대 20MB -->
            <max-request-size>62914560</max-request-size>   <!-- 파일 전체 최대 60MB -->
        </multipart-config>
        - <form>태그에 속성 추가
            - enctype="multipart/form-data" : 양식을 속성으로 추가
                - 양식데이터와 파일데이터를 나워서 보내기 위함
    - 사용
        - Multipart file 매개변수 주입
    - 정적 경로 설정
        - WebMvcConfigurer::addResourceHandlers에 설정