# 스프링 프레임워크 - jdbcTemplate

## jdbcTemplate 란?
    - jdbc 프로그래밍의 단점을 보완
        - 반복적인 코드를 자동으로 전환
    - jdbc(java database connectivity) : 데어터베이스와 서버의 연결제어
    - JDBC API 로 사용
    - 커넥션 풀 + Tomcat JDBC(Hikari CP...)을 주로 사용

## jdbcTemplate 의존성 설정
    - spring jdbc
    - tomcat jdbc(커넥션 풀)
    - ojdbc8

## 커넥션 풀 이란?
    - 데이터베이스 연결 객체를 미리 여러개 생성해 놓은 저장소 : 스프링 컨테이너 DB버전
    - 일정기간 사용하지 않으면 자동으로 연결 해제 : 연결 상태를 확인하는 기능 구현 필요

## DataBase 설정
    - 데이터베이스 연결
    - 스프링 관리 객체(Bean) 생성
    - 커넥션 풀(DataSource클래스) 설정

## Tomcat JDBC 의 주요 메서드
    - setInitialSize(long) : 최초 커넥션 풀 커넥션 갯수
    - setMaxActive(long) : 최대 연결 가능한 커넥션 풀 커넥션 숫자
    - setTestWhileIdle(boolean) : 연결 상태 확인 기능 활성화
    - setMinEvictableIdleTimeMillis(int) : 유휴 시간의 최대값 지정 - 넘어가면 연결 해제
    - setTimeBetweenEvictionRunsMillis(int) : 연경 상태 확인 주기 설정(밀리 초)

## jdbcTemplate 로 쿼리 사용
    - int update(...) : INSERT, UPDATE, DELETE의 반환값 - 반영된 레코드 갯수
    - List<T> query(...) : SELECT문의 반환값 - 조회된 레코드
    - T queryForObject(...) : SELECT문, 단일 레코드만 조회가능, 레코드가 1개가 아니면 예외 발생
        - try~catch 구문 사용 필요

## Logback 의존성 설정
    - org.slf4j
    - logback-classic

## 로그
    <?xml version="1.0" encoding="UTF-8" ?>
    <configuration>
        <appender name="stdout" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <pattern>%d %5p %c{2} - %m%n</pattern>
            </encoder>
        </appender>
        <root level="INFO">
            <appender-ref ref="stdout" />
        </root>
        <logger name="org.springframework.jdbc" level="DEBUG" />
    </configuration>
    - 로그 레벨 설정 : 설정 레벨 이상의 로그는 모두 보이게 설정
        - root level="..."
            - FATAL
            - ERROR
            - WARN
            - INFO
            - DEBUG
            - TRACE

## Lombok 추가
    - lombok 의존성 주입
    - @Getter
    - @Setter
    - @ToString
    - @AllArgsConstructor : 모든 멤버변수를 초기화하는 생성자를 생성
    - @NoArgsConstructor : 기본 생성자를 생성
    - @RequiredAllArgsConstructor : 반드시 초기화가 필요한 멤버변수를 생성자 매개변수에 추가
    - @Data : @Getter + @Setter + @ToString + @NoArgsConstructor
    - @Builder : 빌더 패턴 생성
    - @NonNull : 해당 변수의 Null 값을 허용하지 않음\

## ResultSet 인터페이스
    - 조회된 레코드 데이터(1개 레코드)

## PreparedStatementCreator 인터페이스
    - PreparedStatement 클래스
        - 자동 증감번호(PK) 기능

## Connection conn
    - PreparedStatement preparedStatement(String sql, ...)
        - void set자료형(순서, 값)

## 스프링의 익셉션 변환 처리
    - SQLException을 DataAccessException(RuntimeException)으로 변환하여 사용
        - 실행 시 예외처리가 좀더 유용하기 때문에

## @Transactional 에너테이션
    setAutoCommit(false) - 공통기능
    쿼리1 수행
    쿼리2 수행
    ...
    commit(); - 공통기능
    - 공통기능을 자동으로 추가
    - 클래스명 -> 모든 메서드
    - 메서드명 -> 특정 메서드
    - PlatformTransactionManager
    - DataSourceTransactionManager


## 과제
    - JDBC API
    - DB 연결
    - 추가, 수정, 삭제 - 3
    - 조회 - 1
    - PreparedStatement 방식으로 구현
    - 브랜치명 - jdbc_exam