package com.example.dv_android.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.R
import com.example.dv_android.activities.ui.theme.DV_androidTheme
import com.example.dv_android.ui.theme.Typography

class FeedActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DV_androidTheme {
                
            }
        }
    }
    @Preview
    @Composable
    fun TopBar(){
        TopAppBar(backgroundColor = Color.Black) {
            val expanded = remember {
                mutableStateOf(false)
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "DeuVoto",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(vertical = 10.dp),
                    style = Typography.h3,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                TextField(value = "Pesquisar", onValueChange = {}, Modifier.background(color = Color.White))

                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    DropdownMenuItem(onClick = {
                        val navigate = Intent(this@FeedActivity, ProfileActivity::class.java)
                        startActivity(navigate)
                    }) {
                        Text(text = "Meu Perfil")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = "Comunidades")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = "Configurações")
                    }
                    DropdownMenuItem(onClick = { /*TODO*/ }) {
                        Text(text = "Sair")
                    }
                }
            }
        }
    }
}