# 👨‍💻 CalculateProjectOnlyJava
---
사용 언어 : Java

기간 : 2024/10/08 ~ 2024/10/08 (리펙토링 할 수도 있음)
---
## 👨‍💻 About Project 
#### 간단한 계산기 구현 기능
1. level1
   - withdoutClass -> 단순히 클래스를 추가로 생성하지 않고 Main 함수에서 처리
   - withClass
     
     -> interface를 통해 +, -, /, * 기능을 구현
     
     -> interface를 상속받아 switch 문으로 로직 작성

2. level2
   - Calculate class에 calculate 메소드, remove 형성
       - **calculate Method**
     
         -> switch 문을 통해 연산자에 따라 결과값 형성
     
         -> 0으로 나눌 시 예외 처리 

        - **removeRst**
    
          -> result의 값이 비었으면 처리 결과 X
    
          -> result 값이 있다면 첫번째 결과 값 삭제
  
    - Main Method

      -> withClass와 로직은 비슷하나, remove 로직 추가

3. level3
   - Operation Enum class 형성
   - abstract class로 메서드 형성
     -> abstract를 사용한 이유는 각 메서드마다 기능이 다르기 때문!

       - ArithmeticCalculator
         
         -> Generic을 활용해 Number와, Comparable 상속

         -> **calculate Method**

            단순 계산 로직 단 list에 값 추가

         -> **getBiggerRst**

            rambda를 사용해 입력받은 값보다 큰 결과값 들을 출력 (compareTo) 사용

       -  Main

           input값 넣는 로직은 비슷하나, 입력 연산자 값을 enum 값으로 변환
           symbol과 일치하는 값 찾은 후, 찾은 첫번째 값 대입
           계산한 값과 입렵 한 값 비교
--- 
## 🥵 TroubleShooting 
- 비교 값이 안담아지는 현상 
```
첫 번째 숫자를 입력하세요: 1
두 번째 숫자를 입력하세요: 2
기호를 입력하세요 (+, -, *, /): +
결과 : 3.0
비교할 값을 비교하세요 : 
3
입력 값보다 큰 결과 : []
더 계산하시겠습니까? (exit 입력 시 종료)
첫 번째 숫자를 입력하세요:
```
-> 해결 방법 : ArithmeticCalculator에서 람다 사용시 변수값 잘못 사용 rsts를 사용해야 하는데 rst를 사용해 값이 추가가 되지 않음 

- 무한 루프
 ```
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
첫 번째 숫자를 입력하세요: 잘못입력하셨습니다 null
 ```
-> 해결방법 : InputMismatchException에 버퍼 처리 
버퍼는 왜 처리 할까 ? : 버퍼정리 (next.int() 숫자를 읽고, next.line() 메서드 사용시, 새로운 입력을 하기 전에 입력 버퍼에 남아있던 개행문자를 읽는 경우가 생김

- 제네릭 사용의 어색함과 람다 사용의 어색함
  코드를 작성할때 주로 제네릭과 람다는 잘 사용하지 않고 풀어서 쓰는 경우가 많았다.
  그러다 보니 람다 기능에 익숙하지 않은 부분도 있고 제네릭 함수에 익숙 하지 않은 부분도 있다.
  <a-href>https://velog.io/@ik0605/Generic-1,</a> <a-href>https://velog.io/@ik0605/Generic-2</a>
---
## 👨‍💻 부족한점
람다와 제네릭의 사용의 빈번도 늘리기
