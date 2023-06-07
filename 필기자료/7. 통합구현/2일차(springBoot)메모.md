# 스프링 부트

## JSON 응답과 요청 처리
### 1. JSON 이란?
    JSON (JavaScript Object Notation) : 자바 스크립트 객체 표기법

    ex) {"키" : "값", "키" : "값"}
### 2. Jackson 의존 설정
    의존성 : (*boot 에서는 자동적으로 주입이 되어있다.)

    - Jackson databind
    - Jackson datatype jsr310
    
    -> 자바 객체 -> JSON 문자열로 변환
    -> JSON 문자열 -> 자바 객체로 변환
### 3. @RestController
    JSON 으로 응답, 요청을 받을 수 있는 컨트롤러
    응답헤더 : Content-Type = application/json
    문자열 반환 : Content-Type = text/plain
### 4. @ResponseBody
    일반 컨트롤러(@Controller)에서 JSON 으로 응답 할때
### 5. @JsonIgnore
    JSON 변환 제외 항목을 지정한다
### 6. @JsonFormat
    날짜, 시간의 형식을 변경(응답, 요청)할 때 사용한다
### 7. @RequestBody
    ARC(Advanced Rest Client) : 테스트 툴 -> 요청, 응답 테스트 (arc-setup.exe)
    요청 데이터의 형식이 application/json 형식임을 알려주는 애너테이션
### 8. ResponseEntity< T >
    응답 상태 코드 + 응답 바디 데이터를 상세하게 통제할 때 사용한다

    - static status(...) : 응답 상태 코드
        - HttpStatus : 응답 코드 Enum 상수가 정의되어 있다

    - body(T body) : 응답 바디 데이터

    - build() : 응답 바디 데이터가 없는 경우
    자주 사용 되는 응답 코드는 편의 메서드가 정의되어 있다

    - accepted() - 202
    - created(URL..) - 201
    - badRquest() - 400
    - internalServerError() - 500
    - noContent()  - 204
    - notFound() - 404
    - ok() - 200 응답바디가 없을 경우
    - ok(T body) - 200 응답바디가 있을 경우
### 9. @ExceptionHandler
    @RestControllerAdvice

    Jackson Databind

    ObjectMapper
    readValue : JSON 문자열 -> Java 객체로 변환
    writeValueAsString(...) : Java 객체 -> JSON 문자열로 변환 (Java DTO(Data Transfer Object) 객체만 변환 가능)
    에러, 성공 데이터 응답의 통일성

JSONResult
### 10. 빌더 패턴
    getter, setter 를 대신할 수 있는 패턴
    객체를 직접 생성하지 않는다, 생성자 접근 제어자가 private


## Spring Data JPA
### 1. 동작 방식
    1) JPA란?
        - JPA(Java Persistence API)
            - 자바 영속성 API
            - 영속성 : 상태 감지 메모리
            - jakarta ee에서 정의됨
            - 구현체 : hibernate entityManager
            - 데이터베이스 드라이버
                - ojdbc8
            - H2 Database Engine
            - thymeleaf layout dialect    
        - ORM(Object Relational Mapping)
    2) JPA 사용 시 장점
        - 데이터베이스가 바뀌어도 문제없다.
    3) JPA 사용 시 단점
        - 복잡한 쿼리 사용 불가
    4) JPA 동작 방식
    5) 설정하기
        - DDL AUTO 옵션
            - none : 아무것도 하지 않음
            - create : 서버가 시작되면 기본 테이블 DROP->새로 생성(엔티티)
            - create-drop : create와 동일 + 서버가 종료되기 전에 테이블 DROP
            - update : 변경된 엔티티의 구성으로 수정(없으면 추가)
            - validate : 엔티티의 변경사항만 확인, 변경사항이 있는 경우 예외 발생
        - 개발 시 사용 : create, update
        - 실서버 사용 : validate, none
        - EntityManagerFactory 객체 -> EntityManager객체 -> 엔티티 관리
        - EntityManagerFactory : 필요시 의존성 주입 (스프링 관리 객체에 등록되어 있음)
        - EntityManager
            persist(엔티티 객체) : 영속성 상태로 추가(Persistence Context 추가)
            remove(엔티티 객체) : 객체의 영속성상태를 "제거"로 변경
            detach(엔티티 객체) : 객체의 영속성상태를 "변화 감지 안함"으로 변경
            merge(엔티티 객체) : 객체의 영속성상태를 "변화 감지"로 변경
            flush(엔티티 객체) : 객체의 영속성상태를 데이터베이스에 적용
            find(엔티티 클래스.class, 기본키 값) : 영속성 관리되는 엔티티가 있으면 그걸 사용(캐싱),
                                                 없으면 데이터베이스에서 조회하여 영속상태로 보관하여 사용
                - 변화감지는 좋으나 데이터조회에 한계가 있다.
        - JPQL : 엔티티 기준의 쿼리문 작성법 -> 조회된 결과가 영속성 상태에 있도록 한다.
            -> 조인 등의 다양한 쿼리를 사용 가능하지만 개발자의 오타를 잡아낼 수 없다.
    6) Spring Data JPA -> JPA를 보다 쉽게 사용하기 위한 API
        - DAO를 대체하기 때문에 따로 생성할 필요가 없다.
            -> JpaRepository 인터페이스를 제공 -> 구현체는 스프링에서 자동 생성됨(proxy)
        - 

### 2. 엔티티 설계하기
    1) 엔티티 매핑 에너테이션
        - @Entity : 엔티티 클래스
            - 엔티티명=클래스명
        - @Table : 테이블 설정
            - name=테이블명
            - indexes=인덱스 설정
        - @Id : 기본키가 될 속성 지정
        - @GeneratedValue : 자동증감번호 속성으로 설정
            .AUTO : JPA가 데이터베이스에 따라 자동으로 설정
            .TABLE : 증감번호관리용 테이블을 따로 만들어 관리
        - @Lob : BLOB, CLOB을 자동 매핑
        - @Enumerated(EnumType.STRING) : enum클래스의 속성으로 지정
        - @Transient : 엔티티 내부에서만 사용되는 항목 - 테이블에 반영 X
        - @Temporal : 날짜타입 매핑 - DATE클래스 사용시에 쓰던 방식
        - JPA 표준 날짜와 시간 자동 업데이트
            - @CreatedDate : 처음 엔티티가 영속성에 추가될 때
            - @LastModifiedDate : 영속성 상태 변화
            - 영속성 상태 변화를 감지하는 이벤트 리스너 설정 필요
            - 하이버네이트에서 제공하는 에너테이션(비표준)
                - @CreationTimeStamp : insert 시 현재시간 자동적용
                - @UpdateTimeStamp : update 시 현재시간 자동적용
        - @Column : 테이블의 속성에 다양한 조건을 설정
            name : 테이블의 속성명을 지정
            unique : UNIQUE제약조건 추가
            nullable : NULL값 허용 여부 지정
            length : 기본255, 값의 길이를 지정
            insertable : insert 가능 여부 지정
            updatable : update 가능 여부 지정
        - 게시글 저장 엔티티 만들기
            게시글 번호 - 자동
            게시글 제목
            게시글 내용
            게시글 작성자
            작성일시 - 자동
            수정일시 - 자동
        - @MappedSuperClass : 공통 속성화
            - 모든 엔티티가 소유하는 속성을 지정하는 BaseEntity에 사용




