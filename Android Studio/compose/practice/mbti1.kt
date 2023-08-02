@Preview(showBackground = true)
@Composable
fun Mbti() {
    ComposeTheme {
        val mbtiTypes = listOf(
            "INTJ", "INTP", "ENTJ", "ENTP",
            "INFJ", "INFP", "ENFJ", "ENFP",
            "ISTJ", "ISFJ", "ESTJ", "ESFJ",
            "ISTP", "ISFP", "ESTP", "ESFP"
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "MBTI", fontSize = 40.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = R.drawable.mbti_tybes),
                contentDescription = "MBTI"
            )
            Divider(color = Color.Black, thickness = 8.dp)

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (mbtiType in mbtiTypes) {
                    Spacer(modifier = Modifier.height(20.dp))
                    MyMbti(
                        mbtiType = mbtiType,
                        imageId = getResourceId(mbtiType = mbtiType)
                    )
                    when (mbtiType) { //if로 변환해보면 else if라 else 없어도 됨
                        "ENTP" -> MyDivider(color = Color.Red)
                        "ENFP" -> MyDivider(color = Color.Green)
                        "ESFJ" -> MyDivider(color = Color.Blue)
                        "ESFP" -> MyDivider(color = Color.Yellow)
                    }
                }
            }

        }


    }
}

@Composable
fun MyMbti(mbtiType: String, imageId: Int) {
    Text(text = mbtiType)
    Spacer(modifier = Modifier.height(4.dp))
    Image(painter = painterResource(id = imageId), contentDescription = mbtiType)
}

// @Composable -> composable 함수가 없는 일반 함수라서 어노테이션 필요없음.
// 반환 타입이 있는 경우에 소문자 함수명 권장.
// 반환 값이 있기 때문에 else 값이 있어야 함.
// enum을 써야하는 이유. map은 2개 인자 뿐이라 더 요소가 추가되면 enum을 쓰는게 효율적임.
fun getResourceId(mbtiType: String): Int {
    return when (mbtiType) {
        "INTJ" -> R.drawable.intj
        "INTP" -> R.drawable.intp
        "ENTJ" -> R.drawable.entj
        "ENTP" -> R.drawable.entp
        "INFJ" -> R.drawable.infj
        "INFP" -> R.drawable.infp
        "ENFJ" -> R.drawable.enfj
        "ENFP" -> R.drawable.enfp
        "ISTJ" -> R.drawable.istj
        "ISFJ" -> R.drawable.isfj
        "ESTJ" -> R.drawable.estj
        "ESFJ" -> R.drawable.esfj
        "ISTP" -> R.drawable.istp
        "ISFP" -> R.drawable.isfp
        "ESTP" -> R.drawable.estp
        "ESFP" -> R.drawable.esfp
        else -> 0
    }
}

@Composable
fun MyDivider(color: Color) {
    Spacer(modifier = Modifier.height(20.dp))
    Divider(color = color, thickness = 4.dp)
}
