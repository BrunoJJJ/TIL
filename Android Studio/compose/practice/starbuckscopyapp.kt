package com.example.starbuckscopyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starbuckscopyapp.ui.theme.StarbucksCopyAppTheme
import java.time.format.TextStyle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksCopyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showDetailScreen by remember { mutableStateOf(false) }


                    if (showDetailScreen) {
                        DetailScreen {
                            showDetailScreen = false
                        }
                    } else {
                        MainScreen {
                            showDetailScreen = true
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    StarbucksCopyAppTheme {
        MainScreen(onClickDetail = {})
    }
}

@Composable
fun MainScreen(onClickDetail: (String) -> Unit) {

    Box( // 전체 box
        Modifier.fillMaxSize()
    ) {
        Row( // 상단 고정 Row
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "KeyboardArrowLeft"
            )
            Text(
                text = "추천",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )

        }

        Box( // 중첩 box 이용
            Modifier
                .fillMaxSize()
                .padding(top = 56.dp)
        ) {
            Divider()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                MyRow(
                    image = R.drawable.americano,
                    coffeeName = "아이스 카페 아메리카노",
                    engName = "Iced Caffee Americano",
                    price = 4500,
                    onClick = { onClickDetail("아이스 아메리카노") })
                MyRow(
                    image = R.drawable.caffelatte,
                    coffeeName = "아이스 카페 라떼",
                    engName = "Iced Caffe Latte",
                    price = 5000,
                    onClick = { onClickDetail("아이스 아메리카노") })
                MyRow(
                    image = R.drawable.caramelcoldbrew,
                    coffeeName = "씨솔트 카라멜 콜드 브루",
                    engName = "Sea Solt Caramel Cold Brew",
                    price = 6300,
                    onClick = { onClickDetail("아이스 아메리카노") })
                MyRow(
                    image = R.drawable.honeyblacktea,
                    coffeeName = "아이스 자몽 허니 블랙 티",
                    fontsize = 14,
                    engName = "Iced Grapefruit Honey Black Tea",
                    price = 5700,
                    onClick = { onClickDetail("아이스 아메리카노") })
                MyRow(
                    image = R.drawable.coldbrew,
                    coffeeName = "콜드 브루",
                    engName = "Cold Brew",
                    price = 4500,
                    onClick = { onClickDetail("아이스 아메리카노") })
                MyRow(
                    image = R.drawable.matchalatte,
                    coffeeName = "아이스 제주 유기농 말차로 만든 라떼",
                    fontsize = 14,
                    engName = "Iced Malcha Latte from Jeju Organic Farm",
                    price = 6100,
                    onClick = { onClickDetail("아이스 아메리카노") })

            }
        }
    }
}

@Composable
fun MyRow(
    image: Int,
    coffeeName: String,
    fontsize: Int = 16,
    engName: String,
    price: Int,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Starbucks beverage",
            Modifier.clip(shape = CircleShape)
        )
        Column(Modifier.padding(start = 16.dp)) {
            Text(
                text = coffeeName,
                fontWeight = FontWeight.Bold,
                fontSize = fontsize.sp,
                modifier = Modifier.clickable(onClick = onClick)
            )
            Text(
                text = engName,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "${price}원",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    StarbucksCopyAppTheme {
        DetailScreen(onBackPressed = {})
    }
}


@Composable
fun DetailScreen(onBackPressed: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.americano),
                contentDescription = "order page : americano",
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.TopCenter
            )

            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { onBackPressed() },
                    colors = ButtonDefaults.buttonColors(Color(0x881F351F)),
                        modifier = Modifier.clip(shape = CircleShape)) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "KeyboardArrowLeft",
                            modifier = Modifier
                                .size(30.dp),
                            tint = Color(0xFFDDDCDC)
                        )
                    }
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(0x881F351F))) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "share",
                            modifier = Modifier.size(30.dp),
                            tint = Color(0xFFC9C9C9)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 350.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.End
                ){
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(0x881F351F))) {
                        Icon(
                            imageVector = Icons.Default.Add, // zoom 아이콘 없어서 대용
                            contentDescription = "Add",
                            modifier = Modifier.size(30.dp),
                            tint = Color(0xFFC9C9C9)
                        )
                    }
                }
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 450.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .verticalScroll(rememberScrollState())
            )
            {
                Text(
                    text = "아이스 카페 아메리카노",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
                Text(
                    text = "Iced Caffee Americano",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "진한 에스프레소에서 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피",
                    fontSize = 13.sp
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "4,500원",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                TwoButtonsInOne()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0x61DBD8D8))

                ) {
                    Text(
                        text = "블론드/디카페인 커피 Tab에서\n블론드, 디카페인, 1/2디카페인 아메리카노를 주문할 수 있습니다.",
                        fontSize = 13.sp,
                        color = Color(0xFF7E7B7B)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color(0xFF4CAF50)
                    )
                ) {
                    Text(
                        text = "주문하기",
                        color = Color.White
                    )
                }
            }

        }
    }


}

@Composable
fun TwoButtonsInOne() {
    var button1Clicked by remember { mutableStateOf(false) }
    var button2Clicked by remember { mutableStateOf(false) }
    Row(
    ) {
        Button(
            onClick = {
                if (button2Clicked) button2Clicked = false
                button1Clicked = !button1Clicked
            },
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp,
                bottomEnd = 0.dp
            ),
            border = BorderStroke(1.dp, Color.Gray),
            colors = buttonColors(if (button1Clicked) Color.Blue else Color.White),
            modifier = Modifier.fillMaxWidth(0.5f)
        )
        {
            Text(
                text = "HOT",
                color = if (button1Clicked) Color.White else Color.Gray
            )
        }

        Button(
            onClick = {
                if (button1Clicked) button1Clicked = false
                button2Clicked = !button2Clicked
            },
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 16.dp,
                bottomStart = 0.dp,
                bottomEnd = 16.dp
            ),
            border = BorderStroke(1.dp, Color.Gray),
            colors = buttonColors(if (button2Clicked) Color.Blue else Color.White),
            modifier = Modifier.fillMaxWidth(1f) // 앞에서 0.5f를 가지기 때문에 뒤에는 남은 0.5 중 얼마큼의 비중을 줄 지, 그냥 비중을 나누고 싶으면 weight로 각각 1f 주면 됨
        )
        {
            Text(
                text = "ICED",
                color = if (button2Clicked) Color.White else Color.Gray
            )
        }
    }
}
