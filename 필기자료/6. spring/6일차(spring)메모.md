# 스프링 프레임워크

## 타임리프(thymeleaf)
### 1.스프링 MVC와 타임리프 연동 설정
    - thymeleaf-spring5 의존성 주입
    - thymeleaf-extras-java8time 의존성 주입
    - MvcConfig 기본설정
### 2.타임리프 소개
    - thymeleaf-spring5
    - thymeleaf-extras-java8time 
        - 식 객체(#temporals)

## 타임리프 기본문법
### 1.타임리프 주요 식(expression)
    1) 변수식(EL식)
        - ${...}  -> 주로 속성을 가져올 때
    2) 링크식 : @{...} -> 주로 경로를 가져올 때
        - contextPath가 자동으로 추가 : contextPath뒤부터 입력하면 됨
        - 파라미터 추가(쿼리스트링 추가) -> 소괄호 내부의 값을 쿼리스트링으로 적용
        - 변수 -> 파라미터 추가{변수}(변수=${...}) -> 변수를 입력받아 사용가능
    3) 메세지 식
        - #{메세지 코드} -> 다국어 설정용 메세지파일의 메세지코드를 가져올 때
            - 설정사항
                - MessageSource 빈 : 메세지파일(*.properties)
    4) 선택 변수 식 
        - th:object="${동일객체명}") -> 동일객체명.속성명에서 반복되는 부분을 제거가능
            - *{속성명}으로 사용가능
            <section th:object="${member}">
                <h1>회원정보</h1>
                <dl>
                    <dt th:text="#{userId}"></dt>
                    <dd th:text="*{userId}"></dd>   -> ${member.userId}
                </dl>
                <dl>
                    <dt th:text="#{userPw}"></dt>
                    <dd th:text="*{userPw}"></dd>
                </dl>
                <dl>
                    <dt th:text="#{userNm}"></dt>
                    <dd th:text="*{userNm}"></dd>
                </dl>
                <dl>
                    <dt>가입일시</dt>
                    <dd th:text="*{regDt}"></dd>
                </dl>
            </section>
        - th:block : 아무 틀도 없는 태그
            - th:object를 section태그 없이 사용할 때 적용
        - 직접 정의
            - [[${변수식}]]
            - [[@{경로}]]
            - [[#{메세지코드}]]
### 2.타임리프 식 객체(내장객체)
    - 커스텀 객체
        - ${@스프링빈 이름.메서드명/속성명}
        - *{@스프링빈 이름.메서드명/속성명}
    - basic 객체 : https://github.com/yonggyo1125/curriculum300H/6.Spring & Spring Boot(75시간)/15~16일차(6h)-타임리프(Thymeleaf)/Expression Basic Objects
        - #ctx : context객체
            ${#ctx.locale}      
            ${#ctx.variableNames}
            ${#ctx.request}     
            ${#ctx.response}   
            ${#ctx.session}     
            ${#ctx.servletContext}
        - #locale : java.util.Locale접근 객체
            ${#locale}
        - param : request의 파라미터에 접근
        - session : session의 속성에 접근
        - application : application의 속성에 접근
        - #request : request객체 자체에 접근
        - #session : session객체 자체에 접근
        - servletContext : servletContext객체 자체에 접근
    - utility 객체 : https://github.com/yonggyo1125/curriculum300H/6.Spring & Spring Boot(75시간)/15~16일차(6h)-타임리프(Thymeleaf)/Expression Utility Objects
### 3.th:text -> 식의 내용을 텍스트로 출력(태그인식 안됨)
    - th:utext -> 식의 내용을 텍스트로 출력하며 태그를 인식하여 적용 : 태그는 addAttribute이전에 적용하여 넘겨야함
### 4.th:each -> 식의 내용을 하나씩 꺼내 반복
    - th:each="속성명, status : ${변수명}" -> 변수명에서 값을 1개씩 꺼내 속성명에 저장,태그실행 후 반복
    - status : 
        .index : 0부터 증가번호
        .count : 1부터 증가번호
        .first : 첫번째만 true
        .last : 마지막만 true
        .even : 짝수만 true
        .odd : 홀수만 true
### 5.th:if, th:unless
    - th:if="${...}" -> EL식이 참일 때만 해당 태그내용 출력
    - th:unless="${...}" -> EL식이 거짓일 때만 해당 태그내용 출력
### 6.th:href
    - th:href="@{경로}" -> 경로로 가는 링크 생성
        -> 경로=절대경로("/...") -> 컨택스트경로 + 적용부분
        -> 경로=상대경로("...") -> 컨택스트경로/상대경로시작/ + 적용부분


## 5/23일 시험문제
    글을 작성하고 조회할 수 있는 웹 프로그램을 다음의 절차에 따라 구현하시오.

    1. STS를 설치하고 프로그램 작성에 필요한 스프링 부트 의존성 및 설정을 하시오.

    2. 글을 작성하는데 필요한 기능의 명세와 테스트 항목을 정리하시오.(정리는 작성하는 테스트 케이스 메서드의 주석으로 간단하게 정리할 것)

    3. 기능의 명세에 따른 테스트 케이스를 작성하고 테스트가 통과된 공통 모듈을 배포 위치로 옮겨 반영하시오.

    4. 글 작성을 위한 양식 및 보기 페이지는 타임리프를 사용하여 구성하시오.

    5. 시간대 별 글 작성 횟수를 파악할 수 있는 배치프로그램을 구현하시오.

    (배치프로그램의 스케줄링은 매일 새벽 1시에 정각에 실행되도록 설정)

    6. 웹 프로그램을 작성하는 동안 형상관리툴을 사용하여 관리 하시오.