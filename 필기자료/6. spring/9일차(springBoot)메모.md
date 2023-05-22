# 스프링 부트
## 스프링부트 설정
### 1. 스프링부트 생성
    - spring initializr검색 -> 스프링 부트 파일 생성 -> generate
### 2. 스프링부트 의존성 추가
    - ojdbc8
    - thymeleaf layout
    - Spring Boot Starter Validation

### 3. application.properties 설정
    # 서버 포트 설정
    server.port=3000
    # 라이브 리로드 설정 (코드 수정 시 자동 재시작, 개발시에만 사용)
    spring.devtools.livereload.enabled=true
    # 타임리프 설정
    spring.thymeleaf.cache=false
    spring.thymeleaf.prefix=file:src/main/resources/templates/
    # 정적 자원(css, js, img) 설정
    spring.resources.static-locations=file:/src/main/resources/static/
    # 스프링 JDBC 설정
    spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
    spring.datasource.username=BOARD2
    spring.datasource.password=aA123456

### 4. 스프링부트 셋팅 설정
    - settings -> Build... -> Compiler -> Bulid Project automatically 체크
    - settings -> Advanced Settings -> Compiler -> allow auto-make to... 체크
    - settings -> Editor -> file encodings -> UTF-8로 설정, src를 path에 추가
    - chrome -> LiveReload 확장기능 설치 -> 활성화

## 스케쥴러(Scheduled)
### 1. @EnableScheduling : 스케쥴 기능 활성화
    - cron() : 지정한 시간에 메서드 실행
        *  *   *  *  *   * 
        초 분 시간 일 월 요일
        /*10 : 10초 마다 실행
### 2. @Scheduled : 스케쥴러에 따라 실행될 메서드 지정






### 게시판 만들기
1. SQL
    게시글번호
    제목
    내용
    등록일시

### TDD테스트에 @Transactional 넣으면 테스트 후 DB데이터 일소
