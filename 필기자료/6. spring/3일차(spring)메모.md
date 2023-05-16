# 스프링 프레임워크

## 스프링 컨테이너 과정 
1. 객체생성
2. 의존설정
3. 초기화
    - InitializingBean 인터페이스 : 스프링컨테이너 설정을 위한 설계틀
      - afterPropertySet() : 객체 생성, 의존성 주입 이후 실행할 동작 설정(주로 init 설정)
    - 외부라이브러리나 데이터베이스 등 통제 불가할 때는 @Bean 의 initMethod() 로 설정 
      - @Bean(initMethod = "메서드명")
      - 해당 객체의 클래스에서 메서드명으로 메서드 생성하여 내부에 정의
4. 소멸
   - DisposableBean : 스프링컨테이너 설정을 위한 설계틀
     - destroy() -> ctx.close() 호출 시, 컨테이너 소멸 전 실행할 동작 설정(주로 자원 해제)
   - 외부라이브러리나 데이터베이스 등 통제 불가할 때는 @Bean 의 destroyMethod() 로 설정
     - @Bean(destroyMethod = "메서드명")
     - 해당 객체의 클래스에서 메서드명으로 메서드 생성하여 내부에 정의

## 빈 객체의 생성과 관리 범위
   - @Scope 에너테이션 사용
     - singleton : 동일객체(기본값)로 생성
     - prototype : 다른객체로 생성

## AOP 프로그래밍 - Aspect Oriented Programming
   1. 프록시(Proxy) - 대리하다. 
      - 기존기능을 대신 수행하면서 기존기능 전후로 추가 기능을 수행하는 것(==데코레이터 패턴)
   2. AOP 프로그래밍 구현
      1) spring-aop-api : spring-context 의존성 주입 시 같이 주입됨 
      2) spring-aspectjweaver 의존성 추가
      3) 설정클래스에 @EnableAspectJAutoProxy : 프록시 객체가 있으면 자동으로 설정 후 생성
        - 대상객체가 인터페이스를 상속하면 인터페이스 기준으로 프록시 생성
          - proxyTargetClass=true 로 설정하면 해결된다. 
      4) 클래스를 @Aspect 클래스로 지정
      5) @Around 로 process() 메서드를 만들어 대상을 @Pointcut 메서드로 지정
        - @Around : 메서드에 공통 기능을 추가
          - 핵심속성 : @Around("대상이 되는 메서드명을 지정")
          - 핵심속성 : (ProceedingJoinPoint joinPoint) throws Throwable
            - Object proceed() : 핵심기능을 저장,실행하는 메서드
            - Signature getSignature() :
            - Object getTarget() : 원래 객체를 저장한 메서드
            - Object[] getArgs() : 매개변수로 넘어온 값을 저장한 메서드
      6) 
      7) 메서드에 @Pointcut 으로 메서드의 기능이 적용될 범위지정
        - execution="..." 내부에 범위를 명시자 표현식 형태로 입력
          - execution 명시자 표현식
            - (public void set*(..))
            - (* aopex.\*.*())
            - (* aopex..\*.*(..))
            - (Long aopex.Calculator.factorial(..))
            - (* get*(*))
            - (* get*(\*,*))
            - (* read*(Integer, ..))
      7) @Order(숫자) 를 입력해 프록시의 실행순서 결정
      8) 프록시가 1개면 @Pointcut 없이 @Around 에 범위지정 가능
      9) 동일한 Pointcut 을 여러곳에서 사용하면 따로 클래스를 빼서 공통으로 사용 가능
       