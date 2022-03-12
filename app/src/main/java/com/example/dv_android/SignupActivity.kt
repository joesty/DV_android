package com.example.dv_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.ui.theme.DV_androidTheme

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupContent()
        }
    }

    @Composable
    fun SignupContent(){

        val localFocus = LocalFocusManager.current

        val visible = remember {
            mutableStateOf(false)
        }

        val checked = remember {
            mutableStateOf(false)
        }
        val scrollState = rememberScrollState()
        val stateName = remember {
            mutableStateOf("")
        }
        val stateLastName = remember {
            mutableStateOf("")
        }
        val stateEmail = remember {
            mutableStateOf("")
        }
        val statePassword = remember {
            mutableStateOf("")
        }
        val stateConfirmPassword = remember {
            mutableStateOf("")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState))
        {
            Spacer(modifier = Modifier.padding(20.dp))

            Text(text = "Cadastro", fontSize = 20.sp,)

            Spacer(modifier = Modifier.padding(20.dp))
            //primeiro nome
            OutlinedTextField(
                value = stateName.value,
                onValueChange ={stateName.value = it},
                label = { Text(text = "Nome")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Email,
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
            //segundo nome
            OutlinedTextField(
                value = stateLastName.value,
                onValueChange = { stateLastName.value = it},
                label = { Text(text = "Segundo Nome")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Email,
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
            //e-mail
            OutlinedTextField(
                value = stateEmail.value,
                onValueChange = {stateEmail.value = it},
                label = { Text(text = "E-mail")},
                //visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Email,
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

            //senha
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

            //confirmar senha
            OutlinedTextField(
                value = stateConfirmPassword.value,
                onValueChange = {stateConfirmPassword.value = it},
                label = { Text(text = "Confirmar Senha")},
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
            Spacer(modifier = Modifier.padding(20.dp))

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Ler Termos de uso", color = Color.Red)
            }

            Row() {
                Checkbox(checked = checked.value, onCheckedChange = {
                    checked.value = !checked.value
                },)
                Text(text = "Eu Concordo com os termos de uso", Modifier.padding(top = 15.dp))

            }
            Spacer(modifier = Modifier.padding(5.dp))
            if (visible.value){
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Você deve aceitar os termos de uso para prosseguir",
                        textAlign = TextAlign.Center,
                        color = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Button(onClick = {
                if(checked.value) {
                    val navigateToQuestions =
                        Intent(this@SignupActivity, QuestionsActivity::class.java)
                    startActivity(navigateToQuestions)
                }else{
                    visible.value = true
                }
            }) {
                Text(text = "Prosseguir")
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}
