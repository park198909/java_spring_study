# 스프링 부트
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




