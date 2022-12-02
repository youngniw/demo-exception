# demo-exception
[SpringBoot] 예외(exception) 처리 예제 프로젝트

---
<h3>- 간략한 실습 프로젝트 소개</h3>

- 사용자 추가/조회, 게시물 추가/조회/수정/삭제의 기능을 수행하는 프로젝트
- 예외 발생 시, 커스텀하게 예외 처리로 결과를 반환

<br/>
<h3>- 개발 환경 및 기술 스택</h3>

- Spring Boot
    - Lombok
    - Spring Web
    - Spring Data JPA
    - Validation
- Gradle
- Java 11
- H2

<br/> 
<h3>- 예외 처리 방법</h3>

- @RestControllerAdvice: 모든 RestController 에 대한 예외를 처리할 수 있도록 함
  - 각각의 예외에 대한 @ExceptionHandler 를 선언하여 명시한 예외에 따른 Http Status 와 함께 에러 정보(id, status, message)를 반환함

<br/>

[ 예시 ]

1. MethodArgumentNotValidException
    - @Valid 를 명시한 객체에서 유효성 검증에 실패한 경우 MethodArgumentNotValidException 예외 발생
      - ex) 예외로는 값의 크기가 지정 범위를 넘어가거나, 값이 없는 경우 
   
    - 응답 상태 코드: 400 Bad Request
    - 응답 데이터: 유효성 검사 어노테이션에 담은 message 정보에 따라 예외 이유를 포함해 전달
      - [message 주제]
        1. blank: 요청 파라미터의 값이 없거나 공백인 경우
        2. range: 지정한 범위를 벗어난 경우

<br/>

2. BadRequestException (커스텀한 예외)
    - @Valid 유효성 검증에는 성공했지만 실제로 값이 유효하지 않은 값일 경우
      - ex) 데이터베이스에 저장된 값이 아닌 경우, 로그인 정보 불일치
   
    - 응답 상태 코드: 400 Bad Request 
    - 응답 데이터: 유효성 검사 어노테이션에 담은 message 정보에 따라 예외 이유를 포함해 전달
