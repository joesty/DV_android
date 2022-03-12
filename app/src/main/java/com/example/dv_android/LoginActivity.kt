package com.example.dv_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.ui.theme.DV_androidTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginContent()
        }
    }

    @Composable
    private fun LoginContent(){
        var stateEmail = remember {
            mutableStateOf("")
        }
        var statePassword = remember {
            mutableStateOf("")
        }
        val localFocus = LocalFocusManager.current
        Scaffold() {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Entrar", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(20.dp))
                OutlinedTextField(
                    value = stateEmail.value,
                    onValueChange = {stateEmail.value = it},
                    label = { Text(text = "E-mail")},
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            localFocus.clearFocus()
                        }
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                OutlinedTextField(
                    value = statePassword.value,
                    onValueChange = {statePassword.value = it},
                    label = { Text(text = "Senha")},
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            localFocus.clearFocus()
                        }
                    ),
                    singleLine = true,

                )
                Spacer(modifier = Modifier.padding(10.dp))

                Text(text = "Caso não tenha uma conta ")

                TextButton(onClick = {
                    val navigateToRegister = Intent(this@LoginActivity, SignupActivity::class.java)
                    startActivity(navigateToRegister)
                }) {
                    Text(text = "Cadastre-se", color = Color.Red)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Button(onClick = {
                    val navigate = Intent(this@LoginActivity, AnotherActivity::class.java)
                    startActivity(navigate)
                }) {
                    Text(text = "Navigate", fontSize = 20.sp)
                }
            }
        }
    }
}