@composable - 아래 함수는 일반 함수가 아닌 compose를 위한 함수다 의미

state
변수를 선언하기 위함. 전역변수 개념은 compose와 상충됨. 쓰지 않음. 없음. 더 상위 함수에 적용된 변수를 가져오는 느낌.

remember를 이용하지 않으면 setContent{}블록을 첨부터 끝까지 실행하는 Recompose가 다시 수행된다. remember를 통해 Recompose 전 State를 저장하고 Recompose 일어났을 때 복구하는 것이 필요.

fun MyButton(name: String, size: Int) {
//composable에서 변수명 적을 때 state // alt+enter -> import 2번 1번째는 remember 2번째는 get, set을 위해
var count by remember { mutableStateOf(0) }
//value 값 : 문자, 숫자, type 다 들어갈 수 있음.

}

A : Textfield, Surface
textfield https://www.jetpackcompose.net/textfield-in-jetpack-compose

B : @Composable(재사용)
C : state
D : Scrolling(Column, Row)


