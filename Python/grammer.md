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
