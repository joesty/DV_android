package com.example.dv_android.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.R
import com.example.dv_android.activities.ui.theme.DV_androidTheme


class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DV_androidTheme {
                PerfilContent()
            }
        }
    }
    @Composable
    fun PerfilContent(){

        var edit by remember { mutableStateOf(false)}
        var email by remember { mutableStateOf("email@emai.com")}
        var city by remember { mutableStateOf("Belo Horizonte")}
        var state by remember { mutableStateOf("Minas Gerais")}

        val localFocus = LocalFocusManager.current

        Card(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .pointerInput(Unit){
                        detectTapGestures(onTap = {
                            localFocus.clearFocus()
                        })
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "user_img",
                    modifier = Modifier.clip(CircleShape)
                )
                Text(text = "Joao", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(top = 20.dp))
                Row(modifier = Modifier.padding(top = 40.dp)){
                    //Text(text = "Email:", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    //Spacer(modifier = Modifier.padding(10.dp))
                    TextField(
                        value = email,
                        onValueChange = {
                                        email = it
                        },
                        label = { Text(text = "Email",
                            fontWeight = FontWeight.Bold)},
                        enabled = edit,
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
                        singleLine = true
                    )
                }
                Row(modifier = Modifier.padding(top = 20.dp)){
                    //Text(text = "Cidade:", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    //Spacer(modifier = Modifier.padding(10.dp))
                    TextField(
                        value = city,
                        onValueChange = {
                                        city = it
                        },
                        label = { Text(text = "Cidade",
                            fontWeight = FontWeight.Bold)},
                        enabled = edit,
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
                        singleLine = true
                    )
                }
                Row(modifier = Modifier.padding(top = 20.dp)){
                    //Text(text = "Estado:", fontWeight = FontWeight.Bold, fontSize = 15.sp )
                    //Spacer(modifier = Modifier.padding(10.dp))
                    TextField(
                        value = state,
                        onValueChange = {
                                        state = it
                        },
                        label = { Text(text = "Estado",
                            fontWeight = FontWeight.Bold)},
                        enabled = edit,
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
                        singleLine = true
                    )
                }
                Row(Modifier.padding(top = 40.dp)) {
                    Button(onClick = { edit = !edit }) {
                        if(!edit) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Editar Perfil",
                            )
                            Spacer(modifier = Modifier.padding(10.dp))
                            Text(text = "Editar Perfil")
                        }else{
                            Icon(imageVector = Icons.Default.Done , contentDescription = "Salvar Perfil" )
                            Spacer(modifier = Modifier.padding(10.dp))
                            Text(text = "Salvar Perfil")
                        }
                    }
                }
            }
        }
    }
}

