// 코틀린이 없어서 ```java ```로 코드를 표기함.

```java
var lastClickTime by remember {
    val timeValue = sharedPref?.getString("currentTime", getCurrentTimeFormatted()) ?: ""
    mutableStateOf(timeValue)
}
var count by remember {
    val countValue = sharedPref?.getInt("counter", 0) ?: 0
    mutableStateOf(countValue)
}
/* 중략 */
Button(
    onClick = {
        count++
        lastClickTime = getCurrentTimeFormatted()
        sharedPref?.edit {
            putInt("counter", count)
            putString("currentTime", lastClickTime)
            apply()
        }

    },
    colors = ButtonDefaults.buttonColors(textColor)
) {
    Text(
        text = "$count",
        fontSize = fontsize
    )
}

```

current time을 받기 위해 getString을 쓰지않고 getInt로 썼다가 getString으로 중간에 바꾸는 바람에 폰으로는 실행이 되지만 에뮬레이터에서는 이전에 썼던 키 값이 저장되어 실행이 되지 않음.

에뮬레이터 상 앱을 꾹 눌러 App Info -> 저장소 -> 앱 캐시 및 데이터 삭제
