// 추가
// 0 초기화 버튼
// 숫자 감소 버튼
// double 버튼
// half 버튼
// last click time 저장 버튼

package com.example.countupdown

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.core.content.edit
import com.example.countupdown.ui.theme.CountUpDownTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountUpDownTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountButton()
                }
            }
        }
    }
}

enum class CountColor(val color: Color) {
    RED(Color.Red),
    ORANGE(Color(0xFFFFA500)), // Orange color
    YELLOW(Color.Yellow),
    GREEN(Color.Green),
    BLUE(Color.Blue),
    INDIGO(Color(0xFF4B0082)), // Indigo color
    PURPLE(Color(0xFF5A004E)),
    BLACK(Color.Black)
}

fun getCurrentTimeFormatted(): String {
    val currentTime = Date()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(currentTime) // 현재 시간을 "yyyy-MM-dd HH:mm:ss" 형식으로 포맷팅하여 반환
}


@Preview(showBackground = true)
@Composable
fun CountButton() {
    CountUpDownTheme {
        val activity = LocalContext.current as? Activity
        val sharedPref =
            remember {
                activity?.getPreferences(Context.MODE_PRIVATE)
            }
        var lastClickTime by remember {
            val timeValue = sharedPref?.getString("currentTime", getCurrentTimeFormatted()) ?: ""
            mutableStateOf(timeValue)
        }
        var count by remember {
            val countValue = sharedPref?.getInt("counter", 0) ?: 0
            mutableStateOf(countValue)
        }
        val fontsize = when (count) {
            in 0..99 -> 16 + (count / 10) * 8
            in 100..999 -> 88 + (count / 100) * 8
            else -> 160
        }.sp

        val textColor = when {
            count >= 600 -> CountColor.INDIGO.color
            count >= 500 -> CountColor.BLUE.color
            count >= 400 -> CountColor.GREEN.color
            count >= 300 -> CountColor.YELLOW.color
            count >= 200 -> CountColor.ORANGE.color
            count >= 100 -> CountColor.RED.color
            count <= 99 -> CountColor.BLACK.color
            else -> CountColor.PURPLE.color
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = "Remember your count!",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )


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

            Column(
                horizontalAlignment = CenterHorizontally
            ) {
                Text(
                    text = "functions",
                    fontSize = 24.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // 0 초기화 버튼
                    Button(
                        onClick = {
                            count = 0
                            sharedPref?.edit {
                                putInt("counter", count)
                                apply()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.White)

                    ) {
                        Text(
                            text = "RESET",
                            color = Color.Black
                        )
                    }
                    // 숫자 감소 버튼
                    Button(
                        onClick = {
                            count--
                            sharedPref?.edit {
                                putInt("counter", count)
                                apply()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(
                            text = "minus",
                            color = Color.Black
                        )
                    }
                    // 2배 버튼
                    Button(
                        onClick = {
                            count *= 2
                            sharedPref?.edit {
                                putInt("counter", count)
                                apply()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(
                            text = "double",
                            color = Color.Black
                        )
                    }
                    // 1/2 버튼
                    Button(
                        onClick = {
                            count /= 2
                            sharedPref?.edit {
                                putInt("counter", count)
                                apply()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(
                            text = "half",
                            color = Color.Black
                        )
                    }
                }
                // last click time button
                Button(
                    onClick = {
                        sharedPref?.edit {
                            putInt("counter", count)
                            putString("currentTime", lastClickTime)
                            apply()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text(
                        text = "click time : $lastClickTime",
                        color = Color.Black
                    )
                }
            }
        }
    }

}


/*
cf. 처음에 getInt를 getString으로 바꾸지않고 getInt에 넣기 위해 시간 계산 함수를 반환형 Int로 받기 위해 고생함.
fun getCurrentTimeFormatted(): Int {
    val currentTime = Date()
    val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val formattedTime = dateFormat.format(currentTime)
    // val new = formattedTime.split(":").map { it.toInt() }
    val timeParts = formattedTime.split(":")
    val hours = timeParts[0].toInt()
    val minutes = timeParts[1].toInt()
    val seconds = timeParts[2].toInt()

    // 시간을 Int로 계산하여 반환 (예: 13:45:30 -> 134530)
    return hours * 10000 + minutes * 100 + seconds
}
위 함수 부분 코틀린 식으로 바꿀 수 있음
// java식
val timeParts = formattedTime.split(":")
    val hours = timeParts[0].toInt()
    val minutes = timeParts[1].toInt()
    val seconds = timeParts[2].toInt()

============================================
// kotlin식
val new = formattedTime.split(":").map { it.toInt() }
*/
