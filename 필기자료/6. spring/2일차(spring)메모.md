# 스프링 프레임워크
## 스프링 컨테이너의 특징
- 객체를 싱글톤 객체로 생성한다.
- DI(Dependency Injection) : 의존성 주입
- 확장에 유리한 열려있는 구조로 이루어져 있다. - 전략패턴

## 스프링 DI
- DI 방식
  - 생성자 방식
  - setter 메서드 방식
- 다수의 설정클래스 입력가능
  - AnnotationConfigApplicationContext(가변매개변수)
  - @Import(value=설정클래스.class)
      - 가변매개변수가 아닌 @Import 를 입력하여 추가 대상으로 지정 가능
- 스프링컨테이너에서 객체 꺼내기
  - AnnotationConfigApplicationContext 의 변수명.getBean(Bean 메서드().class) 형태로 객체 꺼내기 가능

## 의존성 자동 주입
- @Autowired 에너테이션 : 적용된 대상이 컨테이너에 있는 객체이면 의존성을 자동으로 주입
  - 적용가능 범위
    - 멤버변수에 적용 -> 대입
    - setter 메서드의 매개변수에 적용 -> 매개변수에 의존객체를 주입하고 메서드를 호출하여 적용
    - Optional 클래스에 적용 -> null 처리가 가능한 래퍼클래스로 감싸준 객체도 관리가 가능하다.
    - 생성자 매개변수(기본생성자가 없을 때) : @Autowired 를 사용하지 않는다. -> 필요가 없다.
  - @Autowired 사용시 스프링 관리객체가 없으면 에러가 발생한다.
    - 에너테이션의 required=false 로 하면 해결된다.
    - @Nullable 을 같이 사용해도 해결된다.


- 동일한 객체를 생성하는 빈이 2개가 있으면 에러가 나므로 알려줘야 한다. 
  - @qualifier(String str) - 컨테이너의 빈과 적용대상 양쪽에 동일한 str 값을 가진 에너테이션을 적용한다.


- @ComponentScan 에너테이션 
  - value 값에 패키지 범위를 입력하면 해당영역 및 하위영역의 특정 에너테이션을 모두 빈으로 적용한다.
  - 대상이 되는 특정 에너테이션
    - @Component
    - @Service
    - @Configuration
    - @Controller
    - @RestController
    - @Repository
    - @Aspect
    - @ControllerAdvice
    - @RestControllerAdvice
  - 자주 사용하는 속성
    - excludeFilters : 여기에 속하면 제외
      - @ComponentScan.Filter
         - FilterType: 필터링 기준
            .ANNOTATION : 에너테이션을 기준으로 필터링 -> classes=...
            .ASSIGNABLE_TYPE : 클래스, 인터페이스를 기준으로 필터링 -> classes="..."
            .REGEX
            .ASPECTJ : 경로를 기준으로 필터링 -> pattern="..."
              - ANT 패턴
              - pattern="..."
              - \* -> 현재경로의 모든 파일과 패턴
              - ** -> 현재경로를 포함한 하위경로의 모든 파일과 패턴
              - ? -> 문자 1개
              - .* -> 현재 패키지의 하위 클래스
              - ..* -> 현재 패키지를 포함한 하위 패키지 및 클래스
   - 에너테이션 만들기
    - @Target(ElementType.TYPE)
    - @Retention(RetentionPolicy.RUNTIME)

## aspectjweaver 패턴
  - AspectJ Weaver » 1.9.19 의존성 주입

## Bean
  - 빈의 이름 충돌
    - 빈 객체는 클래스명을 카멜식으로 만들기 때문에 충돌하기 쉽다.