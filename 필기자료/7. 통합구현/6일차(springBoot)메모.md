# 스프링 부트
## Spring Security

### 시큐리티 구현
    * UserDetails 인터페이스 : 회원정보 + 권한
        - User 구현 클래스 - username(=userId), password(=userPw)
    * UserDetailsService 인터페이스 
        - username 값(-세션,userId) : 회원정보 조회
    * AuthenticationFailureHandler 인터페이스
        - 로그인 실패시 동작을 설정
    * AuthenticationSuccessHandler 인터페이스
        - 로그인 성공시 동작을 설정
    * 사용자 구분 용 토큰(_csrf) 생성
            - 처리페이지(POST)에서 검증(요청 header)
            - 검증 실패시 403(접근 불가) 발생
            - layout구성 시 포함
                <meta name="_csrf" th:content="${_csrf.token}">
                <meta name="_csrf_header" th:content="${_csrf_.headerName}">
        - ajax : 
    * 권한 구현

    * 오류 페이지 구현
        templates
            error
                401.html - 401 오류 발생시 이동되는 페이지
                403.html - 403 오류 발생시 이동되는 페이지
                404.html - 404 오류 발생시 이동되는 페이지
                500.html - 500 오류 발생시 이동되는 페이지

            에러페이지에 구현되어 있는 내장객체
                path : 에러가 발생한 URL 경로
                status : 응답 코드
                timestamp : 응답 발생 일시(EpochTime)
                error : 에러메시지
                error : 에러메시지들
                exception : 예외 객체
                message : 에러메시지
                trace : 자세한 정보
    * 로그인한 회원의 정보 조회 방법
        - 컨트롤러 요청 메서드(@GetMapping)에 주입
            1) Principal principal 주입
                - String userId = principal.getName();
            2) @AuthenticationPrincipal UserDetails구현객체 주입
                - @AuthenticationPrincipal MemberInfo memberInfo
            3) 주입 없이 UserDetails구현객체 바로 조회
                - MemberInfo memberInfo = (MemberInfo) SecurityContextHolder.getContext()
                                            .getAuthentication().getPrincipal();

### 타임리프 + 스프링 시큐리티6 - 확장기능
### 스프링 시큐리티 + JPA - 확장기능 : 로그인한 회원 - 작성자,수정자 - 자동추가
            


### 인터페이스 명세서

