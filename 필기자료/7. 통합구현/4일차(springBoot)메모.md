# 스프링 부트
## Spring Data JPA
### 7. 연관관계 매핑
    - 외래키를 생성해 조회를 쉽게 하는 기술
    1) 매핑의 종류
        - 다대일(N:1) - @ManyToOne
            - 다수의 게시글 : 한명의 회원
            - 외래키 생성 : Many쪽에 One엔티티명_기본키명으로 생성됨
            - @JoinColumn(name="외래키 필드명"); : 생성되는 외래키명을 지정
            - fetch
                FetchType.EAGER : 즉시 로딩(기본값) : 조인(JOIN)을 처음부터 한다.
                FetchType.LAZY(global전략) : 지연 로딩 : 기본 조회, 조인(JOIN)을 요청시에만 쿼리 실행하여 처리
                    - LAZY로 발생하는 문제 : N+1문제
                        - 필요시마다 추가로 조회하면 1번만 필요한 조회를 N번 추가로 실행하게 된다.
                        - 해결방법
                            1) JPQL fetch 조인
                                @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member")
                            2) 쿼리빌더(querydsl) 사용
                                JPAQueryFactory(EntityManager) -> JPAQuery.***.fetchJoin();
        - 일대다(1:N) - @OneToMany
            - 한명의 회원 : 다수의 게시글
            - @OneToMany(mappedBy("외래키명")) : 연관관계의 주인 명시
            - 관계의 주인은 관계를 수정할 수 있다 = 외래키를 가지고 있다(Many)
        - 일대일(1:1) - @OneToOne
            - 회원 : 주소
            - 관계의 주인 : 외래키가 있는 쪽으로 설정 -> mappedBy
            - 기본전략 : LAZY, 필요시 fetch조인 메서드 생성
        - 다대다(N:N) - @ManyToMany
            - 거의 사용하지 않는다.
            - @JoinColumn 불필요
            - 중간 역할을 하는 테이블이 있다.
            - 상품 : 판매자
            Product  Seller
    2) 순환참조 오류 - 메모리부족
        - 다대일 과 일대일 매핑을 동시에 사용하면 발생한다.
            - toString()이 멤버변수의 값을 getter를 통해 출력하기 때문
            - boardData의 toString이 getMember를 호출하고 
              Member의 toString이 getBoardData를 호출하고... 이하 반복
            - 해결 방법
                1) getter를 사용하지 않고 toString을 직접 멤버 변수로 변경
                2) 연결된 항목의 toString을 제거 : @ToString.Exclude 사용
### 10. 공통 속성화
    - 스프링 시큐리티(spring Security)

### 여러 컬럼을 조합하여 기본키 생성
    - @IdClass
    - UNIQUE 생성
        - 회원 : 게시글번호(id) + 회원번호(uid) -> DB통계용 데이터 저장
        - 비회원 : 게시글번호(id) + (IP + 브라우저정보(User-Agent))(uid)
