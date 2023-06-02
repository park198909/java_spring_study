# 스프링 부트
## Spring Data JPA    
### 8. 영속성 전이
    - 외래키 제약조건 설정
    1) @OneToMany 내장 메서드
        - CASCADE
            - PERSISTPERSIST	부모 엔티티가 영속화될 때 자식 엔티티도 영속화
            - MERGE : 부모 엔티티가 병합될 때 자식 엔티티도 병합
            - REMOVE : 부모 삭제 시 자식도 모두 삭제
            - REFRESH : 부모 엔티티가 refresh되면 연관된 자식 엔티티도 refresh
            - DETACH : 부모 엔티티가 detach 되면 연관된 자식 엔티티도 detach 상태로 변경
            - ALL : 부모 엔티티의 영속성 상태 변화를 자식 엔티티에 모두 전이

## Spring Security
### 1. Spring Security 란?
    - 인증 - 로그인
    - 인가 - 접근 권한 통제
    - 접속 보안(CSRF - Cross Site Request Forge) - 토큰
### 2. 개발환경 설정
    - 메이븐 레포지토리 : Spring Boot Starter Security 3.1.0 의존성 주입
    - 설정
        formLogin : 3.0버전 - 메서드체이닝 / 3.1버전 - 람다식
    - 메이븐 레포지토리 : ModelMapper 3.1.1 의존성 주입

