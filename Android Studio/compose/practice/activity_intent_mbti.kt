package com.example.compose

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val listMbti = listOf(
                        "E" to "외향성",
                        "I" to "내향성",
                        "N" to "직관형",
                        "S" to "감각형",
                        "T" to "사고형",
                        "F" to "감성형",
                        "J" to "판단형",
                        "P" to "인식형"
                    )
                    var mbtiType by remember { mutableStateOf("") }
                    var mbtiPair = listMbti.find { it.first == mbtiType.uppercase() }
                    val intent = Intent(this, MainActivity2::class.java)
                    val context = LocalContext.current
                    
                    Column {
                        TextField(
                            value = mbtiType,
                            onValueChange = { mbtiType = it },
                            placeholder = { Text(text = "E | I | N | S | T | F | J | P") }
                        )
                        Button(
                            onClick = {
                                if (mbtiPair != null) {
                                    if (mbtiType.uppercase() == mbtiPair.first) {
	                                       intent.putExtra("pair_first", mbtiPair.second)
                                        context.startActivity(intent) // 이 부분도 inline으로 가능. (Intent(context, MainActivity2::class.java)).apply { putExtra("pair_first", mbtiPair.second) } 느낌으로 apply, let, use,

                                    }
                                }
                            }
                        ) {
                            Text(text = "GO")
                        }
                    }


                }
            }
        }
    }
}



// MainActivity2

// package com.example.compose

// import android.content.Intent
// import androidx.appcompat.app.AppCompatActivity
// import android.os.Bundle
// import androidx.activity.ComponentActivity
// import androidx.activity.compose.setContent
// import androidx.compose.material3.Text
// import com.example.compose.ui.theme.ComposeTheme

// class MainActivity2 : ComponentActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContent {
//             ComposeTheme {
//                 var data = intent.getStringExtra("pair_first") ?: "데이터 받지 못함"
//                 Text(text = data)
//             }
//         }
//     }
// }
