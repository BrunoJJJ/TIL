package com.example.countupdown

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.core.content.edit
import com.example.countupdown.ui.theme.CountUpDownTheme

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
}


//@Preview(showBackground = true)
@Composable
fun CountButton() {
    CountUpDownTheme {
        val activity = LocalContext.current as? Activity // as는 형변환 activity context 상속 관계라 문제없음
        val sharedPref =
        remember { // 개선하기 위해 remember 추가, by 대신 =
            activity?.getPreferences(Context.MODE_PRIVATE)
        }     // nullable하지 않지만 as뒤에 ? 붙여 null check 윗줄에 activity로 형변환시 실패하면 null 값 될 수 있음
        var count by remember {
            val countValue = sharedPref?.getInt("counter", 0) ?: 0  // key - value 2번째 인자는 counter 없을때 인자값 .은 null 값이 될 수 있음
            mutableStateOf(countValue)
        }
        val fontsize = 16 + (count / 10) * 8
        val fontsizePerTens = 88 + (count / 100) * 8
        val textColor = when {
            count > 600 -> CountColor.INDIGO.color
            count >= 500 -> CountColor.BLUE.color
            count >= 400 -> CountColor.GREEN.color
            count >= 300 -> CountColor.YELLOW.color
            count >= 200 -> CountColor.ORANGE.color
            count >= 100 -> CountColor.RED.color
            else -> CountColor.PURPLE.color
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "this button will remember your count!")

            if (count > 1000) {
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(textColor)
                ) {
                    Text(
                        text = "$count",
                        fontSize = 160.sp
                    )
                }
            } else if (count >= 100) {
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(textColor)
                ) {
                    Text(
                        text = "$count",
                        fontSize = fontsizePerTens.sp
                    )
                }
            } else {
                Button(
                  // 기존
                  // onClick = {
                  //       count++
                  //       sharedPref?.edit()?.putInt("counter", count)?.apply() 
                  //   }
                    onClick = {
                        count++
                        sharedPref?.edit {
                            putInt("counter", count) // 확장성이 늘어남
//                          putInt("counter2", count*2) 이런식으로
                            apply()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                )
                {
                    Text(
                        text = "$count",
                        fontSize = fontsize.sp
                    )
                }
            }

        }
    }
}
