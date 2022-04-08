package com.example.dv_android.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.models.User
import com.example.dv_android.viewmodels.SignupViewModel

class SignupActivity : ComponentActivity() {

    val viewModel:SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupContent()
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun SignupContent(){

        val localFocus = LocalFocusManager.current

        val localKeyboard = LocalSoftwareKeyboardController.current

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

        // opções de genero
        val expandedGender = remember {
            mutableStateOf(false)
        }

        val selectedGender = remember {
            mutableStateOf("")
        }

        val genderOptions = listOf("Masculino", "Feminino", "Não Binário", "Não Informar")

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .pointerInput(Unit){
                    detectTapGestures(onTap = {localFocus.clearFocus()})
                }
        ) {
            Spacer(modifier = Modifier.padding(20.dp))

            Text(text = "Cadastro", fontSize = 20.sp)

            Spacer(modifier = Modifier.padding(20.dp))

            //primeiro nome
            OutlinedTextField(
                value = stateName.value,
                onValueChange ={stateName.value = it},
                label = { Text(text = "Nome")},
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        //localFocus.clearFocus()
                        localKeyboard?.hide()
                    },
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

            OutlinedTextField(
                value = selectedGender.value,
                readOnly = true,
                onValueChange = {selectedGender.value = it},
                label = { Text(text = "Gênero") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            expandedGender.value = !expandedGender.value
                        }
                    )
                },
                modifier = Modifier.clickable {
                    expandedGender.value = !expandedGender.value
                }
            )
            DropdownMenu(
                expanded = expandedGender.value,
                onDismissRequest = {
                    expandedGender.value = false
                },
            ){
                genderOptions.forEach{ label ->
                    DropdownMenuItem(
                        onClick = {
                            selectedGender.value = label
                            expandedGender.value = false
                        },
                    ) {
                        Text(text = label)
                    }
                }
            }

            Spacer(modifier = Modifier.padding(20.dp))

            //termos de uso
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Ler Termos de uso", color = Color.Red)
            }

            //aceite dos termos de uso
            Row {
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

            //prosseguir
            Button(onClick = {
                if(checked.value) {
                    val navigateToQuestions =
                        Intent(this@SignupActivity, QuizActivity::class.java)
                    navigateToQuestions.putExtra("user_name", stateName.value)
                    //seta o usuario
                    val user = User(stateName.value, stateEmail.value, stateConfirmPassword.value)

                    //envia usuario pra view model
                    //viewModel.saveUser(user)


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
