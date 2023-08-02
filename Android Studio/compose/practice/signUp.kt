@Preview(showBackground = true)
@Composable
fun signUp() {
    Surface(color = Color.Black) {
        Column() {
//            var id by remember { mutableStateOf("") }
//            var password by remember { mutableStateOf("") }
//            var rePassword by remember { mutableStateOf("") }
            createTextfield(textLabel = "id", textHint = "hong gil dong")
            createTextfield(textLabel = "password")
            createTextfield(textLabel = "re password")
            Button(
                onClick = {},
     //           enabled =
                ) {
                Text("sign up")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createTextfield(textLabel: String, textHint: String? = null) {
    var textValue by remember { mutableStateOf("") }
    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = { Text(text = "$textLabel") },
        placeholder = { textHint?.let {Text(text = "$textHint")} }
    )

}

// xml의 EditText를 TextField로 구현
// enabled를 위해 textValue 값을 가져오는 것에서 문제. 해결 keyword : state hoisting 공부
// textHint : String? = null 설정, password에 hint값을 띄우지 않으려고 함. “$texthint”가 문자열로 받았기 때문에 ?.let으로 해결


