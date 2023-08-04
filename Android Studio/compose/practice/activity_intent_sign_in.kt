		package com.example.remind

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import com.example.remind.ui.theme.RemindTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemindTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    Column {
                        var id by remember { mutableStateOf("") }
                        var password by remember { mutableStateOf("") }
												// Pair로 구성해봄. id password 비교하기 불편할 듯함.. 나중엔 map으로 
                        var isButtonEnabled = when (Pair(id, password)) {
                            Pair("", "") -> false  // ("", _) how use _?
                            else -> true
                        }


                    TextField(
                        value = id,
                        onValueChange = { id = it },
                        label = { Text(text = "id") }
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "password") }
                    )
                    Row {
                        Button(
                            onClick = { //inline, ctrl+alt+N
                                context.startActivity(
                                    Intent(
                                        this@MainActivity,
                                        MainActivity3::class.java
                                    )
                                )
                            },
                            enabled = isButtonEnabled,
                            colors = buttonColors(containerColor = White, contentColor = Blue)
                        ) {
                            Text(text = "sign in")
                        }
                    }
                    Button(
                        onClick = {
                            val intent =
                                Intent(this@MainActivity, MainActivity2::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Text(text = "sign up")
                    }
                }

            }
        }
    }
}
}
