package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.practice.data.AppDatabase
import com.example.practice.data.MIGRATION_1_2
import com.example.practice.data.MIGRATION_2_3
import com.example.practice.data.User
import com.example.practice.ui.theme.PracticeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetUserName()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GetUserName() {
    val context = LocalContext.current
    val db = remember {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "contacts.db"
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
    }
    val scope = rememberCoroutineScope()
    var userName by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var userPhone by remember { mutableStateOf("") }
    var userAge by remember { mutableStateOf("") }
    var userAddress by remember { mutableStateOf("") }
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = "Name") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
//                    focusedIndicatorColor = Color.Green,
//                    unfocusedIndicatorColor = Color.Gray,
                )
            )
            OutlinedTextField(
                value = userEmail,
                onValueChange = { userEmail = it },
                label = { Text(text = "E-mail") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )
            OutlinedTextField(
                value = userPhone,
                onValueChange = { userPhone = it },
                label = { Text(text = "Phone") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )
            OutlinedTextField(
                value = userAge,
                onValueChange = { userAge = it },
                label = { Text(text = "Age") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )
            OutlinedTextField(
                value = userAddress,
                onValueChange = { userAddress = it },
                label = { Text(text = "Address") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White)
            )

            Button(
                onClick = {
                    val newUser = User(
                        name = userName,
                        email = userEmail,
                        phone = userPhone,
                        age = userAge,
                        address = userAddress
                    )
                    scope.launch(Dispatchers.IO) {
                        db.userDao().insertAll(newUser)
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.White, Color.Black),
                modifier = Modifier.padding(20.dp)
            ) {
                Text(text = "Register")
            }
        }
    }
}
