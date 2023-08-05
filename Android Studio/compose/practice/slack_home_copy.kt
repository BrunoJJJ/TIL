package com.example.slackhomecopy

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slackhomecopy.ui.theme.SlackhomecopyTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlackhomecopyTheme {
                // A surface container using the 'background' color from the theme
                MyCompose()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun MyCompose() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var search by remember { mutableStateOf("") }
        var isVisible by remember { mutableStateOf(true) }
        var isVisible2 by remember { mutableStateOf(true) }

				//전체 box
        Box(
            Modifier.fillMaxSize()
        ) {
            // 상단 Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button( // 버튼 색상, 사이즈, 모양 customizing 하기
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "**")
                }
                Text(text = "************************")

                Button(onClick = { /*TODO*/ }) {
                    Icon(
                        Rounded.Menu,
                        contentDescription = null
                    )
                }
            }


            Box( // 중첩 Box
                Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp, bottom = 56.dp)
            ) {
                Column( // scroll column 구성
                    Modifier
                        .verticalScroll(rememberScrollState())
                ) {


                    TextField(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = search,
                        onValueChange = { search = it },
                        placeholder = { Text(text = "다음으로 이동...") }
                    )

                    Row() { // 아이콘 양 옆 추가 예정
                        Text(text = "고객님의 팀은 무료 평가판을 사용 중입니다.")
                    }
                    MyText(text = "*****") //list 쓰자
                    MyText(text = "*****")
                    MyText(text = "*****")
                    MyText(text = "*****")
                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .clickable { isVisible = !isVisible }, // toggle visibility1
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        // Button to toggle visibility
                        Text(
                            text = "***",
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            if (isVisible) {
                                "▲"
                            } else {
                                "▼"
                            },
                            Modifier.padding(end = 16.dp)
                        )

                    }
                    if (isVisible) {
                        MyText(text = "*******")
                        MyText(text = "_*******")
                        MyText(text = "_*******")
                        MyText(text = "_*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        Row(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .padding(end = 16.dp)
                                .padding(top = 8.dp)
                                .padding(bottom = 8.dp)
                        ) {
                            Icon(
                                imageVector = Rounded.Add,
                                contentDescription = null
                            )
                            Text(text = "채널 추가")

                        }
                    }

                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .clickable { isVisible2 = !isVisible2 }, // toggle visibility2
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "다이렉트 메시지",
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        Text(
                            if (isVisible2) {
                                "▲"
                            } else {
                                "▼"
                            },
                            Modifier.padding(end = 16.dp)
                        )
                    }
                    if (isVisible2) {
                        MyText(text = "slackbot")
                        MyText(text = "정하림(나)")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                        MyText(text = "*******")
                    }
                } // scroll column 끝
            } // box 끝


            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(56.dp)
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom // 하단 고정 row
            ) {
                MyIconText(Rounded.Home, "home")
                MyIconText(Rounded.Send, "DM")
                MyIconText(Rounded.CheckCircle, "멘션")
                MyIconText(Rounded.Search, "검색")
                MyIconText(Rounded.Face, "나")
            }
        }
    }
}


@Composable // composable 함수 첫 문자 대문자
fun MyText(text: String) {
    Text(
        text = "$text",
        modifier = Modifier
            .padding(start = 16.dp)
            .padding(end = 16.dp)
            .padding(top = 8.dp)
            .padding(bottom = 8.dp)
    )

}

@Composable
fun MyIconText(icon: ImageVector, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(text = text)
    }
}
