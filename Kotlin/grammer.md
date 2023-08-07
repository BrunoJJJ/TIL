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

- - -
collection 사용 이유

1. 배열을 선언하면 배열의 크기를 초기에 설정하고 이후에 변경이 불가능하다.
2. 데이터를 검색하는 과정에서 시간이 많이 걸린다.
3. 같은 기본형 데이터 타입의 자료형만 저장할 수 있다.

enum class
enum 객체, java enum에서 class로 확장되면서 상수 -> 속성, 메소드 값 까지 추가할 수 있게 확장된 개념.

null safety / enum 은 필요한 경우에 앞으로

보조생성자 쓸 일 거의 없음. 서버 단에서 계산이 대부분 됨으로 클라이언트 단까지 오지 않음

ordinal 쓸 일 적음

ktor 서버 개발 가능(java는 spring MVC)

- - - 

순차적 - 천공판 순서대로

절차적 - 절차(procedure) == 함수

재사용 가능한 프로시저를 이용한 추상적인 단위 프로그래밍

자료형 필요해짐

객체지향 프로그래밍 .

객체 기본단위가 자료형, 함수로 구성되어 하나의 역할을 수행

추상화(abstraction), 상속(inheritance), 다형성(polymorphism) - 오버라이딩, 오버로딩 개념, 캡슐화(encapsulation) - type을 다양하게 형성할 수 있는? 안해도 되지만 해야하는
private을 활용 접근제어자(제한자) 관련 내용

#### 강한응집력(데이터를 클래스에서 관리), 약한 결합력(객체 간 독립적 설계) - 소프트 디자인 학문에서 다루는 것 중 하나. => 위 두 개념을 잘 활용하여야 중복 코드 감소, 유지 보수 용이

a : public, private, protected, internal

b : overriding

c : 함수 오버로딩(java에만 있는 개념), 함수 기본 값

d : class 상속 (lnheritance)

상속 - 부모 클래스 -> 자식 클래스/ 부모의 속성과 메소드 자식 클래스에서 사용 가능

메소드 오버라이딩 -> 부모 클래스의 메소드를 자식 클래스에서 재정의(자식클래스 메소드만 실행되고 부모클래스 메소드는 무시됨. ) 수정 가능 / 추가 가능(추가를 하기위해 super. 이용)

부모 클래스 메소드도 자식 클래스 메소드와 함께 실행하려면 super() 키워드 사용

메소드 오버로딩(overloading)이란 같은 이름의 메소드를 중복하여 정의하는 것 + 매개변수의 개수, 타입을 다르게 여러 메소드를 정의하는 것

다중상속 - 파이썬, c++은 가능 / c# java는 불가능

함수 기본값 : 매개변수에 미리 값 지정

자바 기본 인자 지원안함

add(a:Int) { return a+0 } add(a:Int, b:Int) { return a+b } 이런 식으로 정의함

// 인터페이스 : abstract, final과 함께 대표적인 규제.

어떤 객체가 특정한 인터페이스를 사용한다면 그 객체는 반드시 인터페이스의 메소드들을 구현해야만 한다. 인터페이스에서 강제하는 메소드를 구현하지 않으면 컴파일 안됨

실질적인 예시는 두 개발자가 클래스를 만들 때, 인터페이스를 통해 매개변수나 메소드를 정의해주면 구체적인 약속을 기반으로 만들 수 있게됨.

하나의 클래스는 여러개 인터페이스 구현 가능

인터페이스를 구현하면 메소드 다 가져와야 함

인터페이스도 상속 됨

인터페이스 멤버는 반드시 public(안쓰면 default 값도)

abstract vs interface

비슷한듯 다른 기능 / 인터페이스는 고유한 형태 / 추상 클래스는 일반적인 클래스

인터페이스는 구체적인 로직 상태 가질수 x 추상 클래스는 가질 수 o

- - -

추상화, 다형성, 상속, 캡슐화

Information hiding

polymorphism

### 객체지향의 5원칙

SOLID 원칙

SRP(단일책임원칙) - 객체는 오직 하나의 책임

OCP(개방 폐쇄 원칙) - 객체는 확장에 대해 개방적, 수정에 대해 폐쇄적 - information hiding과 연관

LSP(리스코프 치환 원칙) - 자식 클래스는 언제나 자신의 부모 클래스를 대체 가능

ISP(인터페이스 분리 원칙) - 인터페이스의 단일 책임, 인터페이스를 작게 나눠 구현

DIP(의존성 역전 원칙) - 추상성이 높고 안정적인 클래스가 불안정한 클래스에 의존하지 않음


A : generic
B : data class, sealed class
c : object expression(object{}로 쓸 수 있음)
d : 인터페이스(abstract, Interface)

data class

보일러 플레이트 코드 : 최소한의 변경으로 여러곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드

Java대신 Kotlin을 사용하는 것 자체만으로 많은 보일러플레이트코드를 제거할 수 있다. 한가지 예로 Kotlin의 data 클래스는 primary 생성자를 선언하는 것만으로 equals(), hashCode(), 
toString(), copy() 등을 자동으로 생성한다.

object() - 클래스의 정의와 인스턴스 생성을 동시에 실행.

필요한 기능 간단 구현, 단일 인스턴스 생성시 사용. 람다 함수 내 익명 객체 생성시 유용 -> 람다 함수와 함께 사용되는 인터페이스를 구현할 수 있음

싱글톤 개념에서 가장 많이 씀. object를 통해 abstract class를 계속 생성할 필요없이 ,,

싱글톤 패턴 - 클래스의 인스턴스가 하나만 생성되도록 보장하는 디자인 패턴

전역적으로 접근 가능한 하나의 인스턴스만을 사용하여 리소스 절약 및 중복 생성 방지

추가적으로, Kotlin에서는 싱글톤 패턴을 더 간단하고 안전하게 구현할 수 있도록 object 키워드를 제공합니다. Kotlin에서는 object 키워드를 사용하여 싱글톤 인스턴스를 생성하고, 해당 인스턴스는 암묵적으로 스레드 세이프하게 초기화됩니다. 따라서 별도의 동기화 코드를 작성하지 않아도 싱글톤 인스턴스를 안전하게 사용할 수 있습니다

보일러플레이트 코드 : 최소한의 변경으로 여러곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드

ex)  enum Color(r : Int) = RED(3)

enum과 sealed 차이

enum은 값 변경 가능 and 안에 값을 쓰는 용도면

sealed는 enum안에 상수 RED를 인스턴스로 생성함.

추상 클래스

[https://inpa.tistory.com/entry/JAVA-☕-추상-클래스Abstract-용도-완벽-이해하기](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%B6%94%EC%83%81-%ED%81%B4%EB%9E%98%EC%8A%A4Abstract-%EC%9A%A9%EB%8F%84-%EC%99%84%EB%B2%BD-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0)

제네릭 : 클래스 내부에서 사용할 자료형을 인스턴스를 생성할 때 확정짓는 것.

객체의 자료형을 컴파일 때 체크하기 때문에(인스턴스 생성 시 확정지어도 되는) + 형변환 쉬움.

기본적으로 null 값 가능. 공변성 반공변성 *

람다식 추가 학습
