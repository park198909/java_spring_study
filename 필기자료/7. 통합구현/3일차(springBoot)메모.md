# 스프링 부트
## Spring Data JPA
### 3. Repository 설계하기
    - CrudRepository의 하위클래스인 JPARepository<엔티티클래스, 기본키 자료형> 인터페이스를 상속 
        -> Repository 생성완료
    - 구현체를 proxy로 자동 생성
    - Dao는 더이상 필요 없음
    - T save(T t) - em.persist
                    - 엔티티를 영속상태로 추가
                    - 반환값 : 영속상태에 있는 엔티티
    - List<T> saveAll(List<T> list) - 영속성에 여러 엔티티를 한번에 추가
    - T saveAndFlush(T t) - save + flush
    - List<T> saveAllAndFlush(List<T> list) - saveAll + flush
    - void delete(T t) - em.remove
                        - 엔티티를 연속성 삭제 상태로 추가
    - void flush(T t) - em.flush()
                        - 변화된 상태를 실제 데이터베이스에 반영
    - long count(...) - 전체 갯수
    - find... : 조회된 결과가 영속성 상태에 있다. 변화를 감지함
        - findById
        - findAll
        - 앞에 추가된 엔티티가 있으면 최종 DB 에 반영하고 조회를 한다. 즉 flush 후 find 실행
    - get... : 조회된 결과가 영속성 분리상태에 있다. 변화를 감지 안함
### 4. 쿼리 메서드
    - Repository 내부에 메서드를 지정하면 자동으로 특정 조건의 find 기능을 수행하는 구현체가 생성됨
    - findBy + 엔티티명 + 키워드 + 검색대상 : 일반적인 형태이나 에티티명을 제외할수 있다.
        - 키워드 : https://github.com/yonggyo1125/curriculum300H/blob/main/6.Spring%20%26%20Spring%20Boot(75%EC%8B%9C%EA%B0%84)/17~20%EC%9D%BC%EC%B0%A8(21h)%20-%20%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/Spring%20Data%20JPA/4.%20%EC%BF%BC%EB%A6%AC%20%EB%A9%94%EC%84%9C%EB%93%9C.md
### 5. @Query 에너테이션
    - JPQL을 바로 작성가능 : 복잡한 쿼리를 직접 작성하여 사용
    - @Query(JPQL문) 형태로 메서드에 적용
    - 쿼리의 문법오류를 실행시에만 확인가능, 유지보수에 좋지 않다.
        - 쿼리빌더 : 자바 코드 수준에서 JPQL완성
            - 오류여부를 즉각적으로 알수 있다.
            - 개발자의 문법 오류 실수 방지
        - jakarta.persistence.criteria : 너무 복잡해서 잘 사용 안함
        - querydsl : 비표준라이브러리 - 자주 사용
        - Pageable : 페이징 관련 인터페이스
            - PageRequest.of(int page, int size, Sort sort) 
                - 1페이지 출력갯수를 설정(쿼리로 작성) + 정렬기능
                - page : 페이지 번호, 0부터 시작
                - size : 페이지당 레코드 갯수
                - sort : 정렬기능, Sort.by(desc("1차필드명"), asc("2차필드명"));
### 6. Querydsl
    - 쿼리빌딩을 할수 있는 클래스를 자동 생성 -> (Q엔티티명.java)
    - 플러그인 설정 필요 : plugin - apt-maven-plugin - mysema    
        - Maven APT Plugin
        <executions>
                <execution>
                    <goals>
                        <goal>process</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>target/generated-sources/java</outputDirectory>
                        <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                    </configuration>
                </execution>
            </executions>
    - 의존성 주입
        - querydsl-jpa
        - querydsl-apt : 쿼리빌딩 클래스 자동 생성 라이브러리
        - <classifier>jakarta</classifier> 추가
    - repository클래스에 QuerydslPredicateExecutor<T> 를 상속하여 사용
        - Q엔티티명 변수명 = Q엔티티명.변수명; // Q클래스에서 싱글톤 객체 가져오기
        - 변수명.findOne||findAll을 사용
            - 조건식이 1개일 때는 Q클래스에서 바로 predicate 를 생성   
                - findOne(변수명.필드명.조건식).orElse(null);
                    eq
                    lt
                    le
                    gt
                    ge
                    in
                    contains
                    startwith
                    endwith
            - 조건식이 여러개일 때는 BooleanBuilder == Predicate 구현클래스
                - BooleanBuilder : 논리연산자를 처리하는 빌더
                    and
                    or
                    not
### 7. 연관관계 매핑
    - 외래키를 생성해 조회를 쉽게 하는 기술
    1) 매핑의 종류
        - 다대일(N:1) - @ManyToOne
            - 다수의 게시글 : 한명의 회원
            - 외래키 생성 : Many쪽에 One엔티티명_기본키명으로 생성됨
            - @JoinColumn(name="외래키 필드명"); : 생성되는 외래키명을 지정
        - 일대다(1:N) - @OneToMany
            - 한명의 회원 : 다수의 게시글
            - @OneToMany(mappedBy("외래키명")) : 연관관계의 주인 명시
            - 관계의 주인은 관계를 수정할 수 있다 = 외래키를 가지고 있다(Many)
        - 일대일(1:1) - @OneToOne
        - 다대다(N:N) - @ManyToMany
    2) 순환참조
        - 다대일 과 일대일 매핑을 동시에 사용하면 발생한다.
        - getter를 사용하지 않고 toString을 직접 멤버 변수로 변경
        - 연결된 항목의 toString을 제거 : @ToString.Exclude 사용
        

