package com.example.dv_android.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.ui.theme.DV_androidTheme
import com.example.dv_android.utils.isAEmail
import com.example.dv_android.utils.isAPassword

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DV_androidTheme() {
                LoginContent()
            }
        }
    }

    @Composable
    private fun LoginContent(){
        val stateEmail = remember {
            mutableStateOf("")
        }
        val statePassword = remember {
            mutableStateOf("")
        }
        var validPassword by remember { mutableStateOf(false)}

        var validEmail by remember { mutableStateOf(false )}

        var tryNext by remember { mutableStateOf(false)}

        val localFocus = LocalFocusManager.current

        Scaffold(
            modifier = Modifier
                .pointerInput(Unit){
                    detectTapGestures(onTap = {
                        localFocus.clearFocus()
                        validPassword = isAPassword(statePassword.value)
                        validEmail = isAEmail(stateEmail.value)
                    })
                }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Entrar", fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(20.dp))
                OutlinedTextField(
                    value = stateEmail.value,
                    onValueChange = {
                        stateEmail.value = it
                        validPassword = isAPassword(statePassword.value)
                        validEmail = isAEmail(stateEmail.value)
                                    },
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
                if(tryNext) {
                    if (!validEmail) {
                        Text(
                            text = "Não é um email válido",
                            color = Color.Red
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = statePassword.value,
                    onValueChange = {
                        statePassword.value = it
                        validPassword = isAPassword(statePassword.value)
                        validEmail = isAEmail(stateEmail.value)
                                    },
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
                if (tryNext) {
                    if (!validPassword) {
                        Text(
                            text = "Não é uma senha válida",
                            color = Color.Red
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(20.dp))

                Text(text = "Caso não tenha uma conta ")

                TextButton(onClick = {
                    val navigateToRegister = Intent(this@LoginActivity, SignupActivity::class.java)
                    startActivity(navigateToRegister)
                }) {
                    Text(text = "Cadastre-se", color = Color.Red)
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Button(onClick = {
                    val navigate = Intent(this@LoginActivity, TesteActivity::class.java)
                    tryNext = true
                    //if(validEmail && validPassword) {
                    if(true){
                        startActivity(navigate)
                    }
                }) {
                    Text(text = "Navigate", fontSize = 20.sp)
                }
            }
        }
    }
}