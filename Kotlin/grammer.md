세미콜론 없음
notation : Pascal Case or Camel Case
변수 선언 var(variable, 일반적) <-> val(value 선언시만, 초기화 read only)
변수 선언 위치에 따라, property (in class), local variable (in scope)
intellij(학생 이메일 인증으로 1년 무료), android studio, kotlin playground 등에서 작업 가능

패키지 - 클래스 집합, 클래스를 묶어두는 물리적 단위
클래스에 package표시는 자동으로 이루어짐, 없으면 디폴트 패키지에 들어있다고 가정되어짐
default package는 import 불가능
패키지와 그 안의 클래스, 함수를 사용하기 위해 import 필요
null관련 안정성 -> null, ?, let etc..
```
//kotlin
firstName?.length

//java
if (firstname != null) {
firstname.length();
} else {
null;
}
```
초기화를 할 때 값을 명시하지 않는다면, 반드시 변수타입을 명시해야함 ex) var age: Int
unsigned를 통해 U를 사용하여 음수 범위만큼 양수 범위 증가. (사용할 경우 많지 않음)
원시 유형은 기본형 + array -> java, kotlin 혼용할 경우 필요
for if 문 중괄호 생략 가능 (생략안하는게 실수 적어짐)

if 대신 when 많이 씀
// kotlin range : step / in 1..3 / in 1 until 4 / in 3 downTo 1  
