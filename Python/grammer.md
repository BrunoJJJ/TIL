### 연산자
and, or 논리연산자 &, | 비트연산자

https://docs.python.org/ko/3/reference/expressions.html#boolean-operations

https://www.codeit.kr/community/questions/UXVlc3Rpb246NjJmMjJhYjMyMTc0NzM0NDA1MWMwNTcy

https://velog.io/@kkiyou/py0040

```c
// ex) c언어 비트 연산자 예시 // 코드잇 답변 참고
#include <stdio.h>

int main()
{
    unsigned char num1 = 3;    // 0000 0011
    unsigned char num2 = 5;    // 0000 0101

    printf("%d\n", num1 & num2);    // 0000 0001: 0011과 0101을 비트 AND => 0001
    printf("%d\n", num1 | num2);    // 0000 0011: 0011과 0101을 비트 OR => 0111
    printf("%d\n", num1 ^ num2);    // 0000 0010: 0011과 0101을 비트 XOR => 0110

    return 0;
}
// 실행결과
/*
첫번째 print값 : 1(10진법) = 0001(2진법)
```


### yield, generator

게으른 반복자.

yield를 이용해 generator 객체를 생성.

return은 한 번에 메모리에 모든 결과 값을 올리는 반면, yield는 메모리에 결과 값을 하나씩 올림.

즉, 대용량 파일 읽기, 스트림 데이터, 무한 데이터 생산 가능

https://www.daleseo.com/python-yield/
