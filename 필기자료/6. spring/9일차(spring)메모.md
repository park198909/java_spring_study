# 스프링 프레임워크
## 스프링 웹 MVC
### 1.파일업로드
    - Multipart 인터페이스
        - 파일과 양식데이터를 나눠서 전송하는 기능을 구현
    - 설정 : 파일 1개의 최대용량, 전체 최대용량 설정
        - web.xml의 servlet에 설정입력
        <multipart-config>
            <max-file-size>20971520</max-file-size>         <!-- 파일 1개당 최대 20MB -->
            <max-request-size>62914560</max-request-size>   <!-- 파일 전체 최대 60MB -->
        </multipart-config>
        - <form>태그에 속성 추가
            - enctype="multipart/form-data" : 양식을 속성으로 추가
                - 양식데이터와 파일데이터를 나눠서 보내기 위함
    - 사용
        - MultipartFile 매개변수 주입
    - 정적 경로 설정
        - WebMvcConfigurer::addResourceHandlers에 설정
### 2.프로필
    - 프로필에 입력된 환경변수에 따라 다른 객체가 생성됨
    - spring.profiles.active
    - @Profiles("환경변수")
        - java 배포파일 : Dspring.profiles.active=환경변수
            -환경변수에 해당하는 프로필로 연결
### 3.프로퍼티
    - PropertySourcesPlaceholderConfigurer 빈 설정 : 설정관련 부분을 파일로 관리
        - static으로 설정해야 함