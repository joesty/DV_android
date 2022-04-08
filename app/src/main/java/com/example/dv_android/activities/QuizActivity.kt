package com.example.dv_android.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class QuizActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userName = intent.getStringExtra("user_name")
        setContent {
            QuestionCard()
        }
    }
    var index = 0
    var questions = listOf<Question>(
        Question("você é feliz?"),
        Question("Você canta?"),
        Question("Você dança?"),
        Question("Você vota no Lula?"),
        Question("Você vota no PT??"),
    )


    @Composable
    fun QuestionCard(){

        var texto = remember {
            mutableStateOf("Questionário")
        }
        var question = remember {
            mutableStateOf(questions[index].text)
        }

        val selected = remember {
            mutableStateOf("favor")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = texto.value, fontSize = 30.sp)
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = question.value, fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(40.dp))

            Row(modifier = Modifier
                .width(120.dp)
                .height(40.dp)) {
                RadioButton(
                    selected = selected.value == "favor",
                    onClick = { selected.value = "favor" },
                )
                Text(text = "Favoravel", textAlign = TextAlign.End, modifier = Modifier.padding(top = 10.dp))
            }

            Row(modifier = Modifier
                .width(120.dp)
                .height(40.dp)) {
                RadioButton(
                    selected = selected.value == "neutro",
                    onClick = { selected.value = "neutro" },
                )
                Text(text = "Neutro", textAlign = TextAlign.End, modifier = Modifier.padding(top = 10.dp))
            }

            Row(modifier = Modifier
                .width(120.dp)
                .height(40.dp)) {
                RadioButton(
                    selected = selected.value == "contra",
                    onClick = { selected.value = "contra" },
                )
                Text(text = "Contrario", textAlign = TextAlign.End, modifier = Modifier.padding(top = 10.dp))
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Button(onClick = {
                //caso não seja o ultimo questionario, continua atualizando a page
                if (index < questions.size-1) {
                    index += 1
                    question.value = questions[index].text
                }else{
                    // termina os questionarios, manda pra viewmodel e seta a proxima atividade
                    val navigatorEndRegister = Intent(this@QuizActivity, TesteActivity::class.java)
                    //viewModel.saveUser()
                    startActivity(navigatorEndRegister)
                }
            }
            ){
                Text(text = "Proximo")
            }
        }
    }
}

data class Question(val text: String)

/*
val fruits = listOf("Maçã", "Morango", "Abacaxi", "Guaraná", "Laranja", "Limão", "Maracujá", "Uva", "Pera")

@Composable
fun questionsContent(){
    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(fruits){
            fruit -> Text(text = fruit)
        }
    }
}*/