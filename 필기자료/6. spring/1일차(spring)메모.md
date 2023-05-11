# 스프링 프레임워크 - 표준화된 설계틀(설명서)

## 스프링의 역할
- 의존주입(DI)
- AOP(Aspect-Oriented Programming) 지원 - 프록시 관리용
- MVC 웹 프레임워크
- DB연동 지원 : JDBC, JPA 연동, 선언적 트랜잭션 처리 등 
- 스프링 컨테이너 관리 : 객체의 의존주입메서드가 모여있는 객체
- 정보은닉 : 정보를 변경,감춰야할 경우 캡슐화하는 것
	- 캡슐화 : 바로 접근가능한 변수를 없애고 메서드를 통해 접근하게 하는것

## 스프링 주요 라이브러리
- spring-context

## 스프링 주요 클래스
- AnnotationConfigApplicationContext : java코드용 스프링 컨테이너 클래스
	- 객체생성 및 에너테이션 설정을 관리
	- 객체를 싱글톤 객체로 생성한다.
	- 의존성 주입 : 객체조립기 역할을 한다.
- GenericXmlApplicationContext : XML용 스프링 컨테이너 클래스
- GenericGroovyApplicationContext : 그루비코드용 스프링 컨테이너 클래스

## 스프링 주요 용어
- IOC : Inversion Of Control : 제어의 역전 
	  : 제어의 주체를 개발자에서 스프링으로 변경
	  : 설정클래스를 통해 에너테이션으로 스프링에게 제어 이관

