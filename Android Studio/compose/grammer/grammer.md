readme.md로 정리 예정

- - - 
안드로이드 권장 dp는 8의 배수 / 작으면 4의 배수

surface 안에 속성 값 처럼 modifier까지 찾아보기

sample code + 결과물

modifider : composable의 크기, 동작, 모양을 변경하거나 사용자의 입력을 처리
(클릭, 스크롤 등)할 수 있도록 만드는 변수

column은 총 4가지 변수를 인자로 받는다.

modifier

verticalArrangement(Arrangement.Vertical 타입) : 수직 배치(Arraygement)를 설정하는 변수

horizontalAlignment(Alignment.Horizontal 타입) : 수평 정렬(Alignment)을 설정하는 변수

content : Layout 안에 들어갈 위젯을 설정하는 변수


Button 형식

Button(onClick = { /*TODO*/ }) {    }

Button 속성

onClick: () -> Unit,

modifier: Modifier = Modifier,

enabled: Boolean = true,

shape: Shape = ButtonDefaults.shape,

colors: ButtonColors = ButtonDefaults.buttonColors(),

elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),

border: BorderStroke? = null,

contentPadding: PaddingValues = ButtonDefaults.ContentPadding,

interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },

content: @Composable RowScope.() -> Unit

interaction은 on click 외에도 버튼을 드래그, 더블클릭 등 역할을 수행할 때 사용

- - -


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

- - -

gradle scripts -> manifests -> android

안드로이드 화면 전환 방법 많음(자주쓰는 4가지)

activity 화면 전환

activity 위에 fragment 구성해 fragment로 전환 (화면 tab 느낌)

androidx nevigation (위 발전)

navigation compose 활용 - https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation?hl=ko#0

qr앱은 웹뷰를 띄운 것.

keyword

intent startactivity

코드작성시 컴파일 버그(디버깅)

이외에 logcat


activity 개념

https://developer.android.com/guide/components/activities/intro-activitieshttps://7942yongdae.tistory.com/176

activity Lifecycle

하기 전 콜백 메소드 https://onlyfor-me-blog.tistory.com/47

// 아래 2개는 activity 간 데이터 주고받을 때 사용하는 개념 keyword

intent extra data

https://8iggy.tistory.com/256

activity Result

apply, with, let, also, run

[https://medium.com/@limgyumin/코틀린-의-apply-with-let-also-run-은-언제-사용하는가-4a517292df29](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29)

http://batmask.net/index.php/2021/12/10/286/

1) 객체를 ‘it’으로 쓰느냐, ‘this’를 쓰느냐, 2) 리턴값이 lambda result이냐, context object이냐에 따라 나뉜다. 4개면 되는데? extension function 형식외에 argument로 context object를 받는 ‘with’가 추가로 하나 존재한다.

