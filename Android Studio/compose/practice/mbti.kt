var list_분석가형 = listOf("INTJ", "INTP", "ENTJ", "ENTP")
        var list_외교관형 = listOf("INFJ", "INFP", "ENFJ", "ENFP")
        var list_관리자형 = listOf("ISTJ", "ISFJ", "ESTJ", "ESFJ")
        var list_탐험가형 = listOf("ISTP", "ISFP", "ESTP", "ESFP")


        Column {
            Text(text = "성격 유형")
            Divider(color = Color.Black, thickness = 4.dp)

            Row() {
                for (i in list_분석가형.indices) { //0..items.size-1 // until items.size // items.indices->IntRange 최소인덱스 ~ 최대인덱스
                    Text(text = "${list_분석가형[i]}")
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Row() {
                for (i in list_외교관형.indices) { //0..items.size-1 // until items.size // items.indices->IntRange 최소인덱스 ~ 최대인덱스
                    Text(text = "${list_외교관형[i]}")
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Row() {
                for (i in list_분석가형.indices) { //0..items.size-1 // until items.size // items.indices->IntRange 최소인덱스 ~ 최대인덱스
                    Text(text = "${list_관리자형[i]}")
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Row() {
                for (i in list_분석가형.indices) { //0..items.size-1 // until items.size // items.indices->IntRange 최소인덱스 ~ 최대인덱스
                    Text(text = "${list_탐험가형[i]}")
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

        }
