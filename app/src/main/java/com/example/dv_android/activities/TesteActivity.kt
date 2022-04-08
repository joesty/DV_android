package com.example.dv_android.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dv_android.R
import com.example.dv_android.ui.theme.DV_androidTheme
import com.example.dv_android.ui.theme.Typography


class TesteActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val words = mutableStateListOf<String>("Joao", "Maria", "Matheus")

        val politics = mutableListOf<Politico>(
            Politico("Lula", "PT", "??"),
            Politico("Bolsonaro", "Nazi", "??"),
            Politico("Ciro", "PDT", "??"),
            Politico("Joao", "PDJ", "??"),
        )

        setContent {
            DV_androidTheme() {
                FeedContent(politics)
            }
        }
    }
    @Composable
    fun PoliticCard(politico:Politico){
        Card(
            Modifier
                .size(width = 160.dp, height = 60.dp)
                .padding(top = 4.dp)
                .padding(start = 10.dp),
            shape = RoundedCornerShape(50),
        ) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 4.dp)) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "userImg",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp)
                        .border(1.5.dp, Color.Red, CircleShape),
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 40.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = politico.name,
                    fontSize = 15.sp,
                    color = Color.Black,
                    style = MaterialTheme.typography.subtitle2,
                )

                Text(
                    text = politico.partido,
                    style = MaterialTheme.typography.body1,
                    fontSize = 10.sp
                )
                Row() {
                    LinearProgressIndicator(
                        progress = 0.5f,
                        modifier = Modifier
                            .size(width = 60.dp, height = 10.dp)
                            .padding(top = 5.dp, start = 2.dp)
                    )
                    Text(text = "50%", fontSize = 10.sp, modifier = Modifier.padding(start = 2.dp))
                }
            }
        }
    }

    @Composable
    fun PoliticBar(politicos: MutableList<Politico>){
        LazyRow(){
            items(politicos){ politico ->
                Spacer(modifier = Modifier.padding(start = 2.dp))
                PoliticCard(politico = politico)
            }
        }
    }

    @Composable
    fun PoliticPost(){
        val buttonClick = remember {
            mutableStateOf(false)
        }
        val infoClick = remember {
            mutableStateOf(false)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(vertical = 10.dp)
                .background(Color.DarkGray),
        ) {
            Card(
                //shape = RoundedCornerShape(10),
                backgroundColor = Color.DarkGray,
                elevation = 10.dp,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
            ) {
                Column() {
                    Row(){
                        Image(
                            painter = painterResource(id = R.drawable.lula),
                            contentDescription = "img",
                            modifier = Modifier
                                .padding(all = 15.dp)
                                .size(35.dp)
                                .clip(CircleShape),
                        )
                        Column(
                            modifier = Modifier.padding(top = 15.dp),
                        ) {
                            Text(text = "Lula",
                                style = MaterialTheme.typography.h3,
                                fontSize = 15.sp,
                                color = Color.LightGray,
                            )
                            Text(
                                text = "5 minutos atrás",
                                fontSize = 8.sp,
                                color = Color.LightGray,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp)
                                .padding(horizontal = 20.dp),
                            horizontalAlignment = Alignment.End,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "Info",
                                tint = Color.LightGray,
                                modifier = Modifier.clickable { infoClick.value = true }
                            )

                            DropdownMenu(
                                expanded = infoClick.value,
                                onDismissRequest = { infoClick.value = false }
                            ) {
                                DropdownMenuItem(onClick = { /*TODO*/ }) {
                                    Text(text = "Denunciar")
                                }
                            }
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(20),
                        elevation = 10.dp,
                        backgroundColor = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp)
                            .border(5.dp, Color.DarkGray, RoundedCornerShape(20)),

                        ) {
                        Text(
                            text = "A casca da arvore era grande de mais para caber na arvore, então a arvore cresceu ate a lua," +
                                    "A casca da arvore era grande de mais para caber na arvore, então a arvore cresceu ate a lua," +
                                    "A casca da arvore era grande de mais para caber na arvore, então a arvore cresceu ate a lua," +
                                    "A casca da arvore era grande de mais para caber na arvore, então a arvore cresceu ate a lua",
                            style = MaterialTheme.typography.body2,
                            fontSize = 10.sp,
                            modifier = Modifier
                                .padding(start = 18.dp, end = 14.dp)
                                .padding(vertical = 18.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Curtir",
                            modifier = Modifier
                                .clickable { buttonClick.value = !buttonClick.value }
                                .padding(horizontal = 20.dp),
                            tint = if(buttonClick.value) Color.Red else Color.LightGray
                        )
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Compartilhar",
                            tint = Color.LightGray,
                            modifier = Modifier
                                .clickable {
                                    val sendIntent: Intent = Intent().apply {
                                        action = Intent.ACTION_SEND
                                        putExtra(Intent.EXTRA_TEXT, "Share")
                                        type = "text/plain"
                                    }

                                    val shareIntent = Intent.createChooser(sendIntent, null)
                                    startActivity(shareIntent)
                                }
                                .padding(horizontal = 20.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Comentar",
                            tint = Color.LightGray,
                            modifier = Modifier
                                .clickable {  }
                                .padding(horizontal = 20.dp)
                        )
                    }
                }
            }
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun preview(){
        val politics = mutableListOf<Politico>(
            Politico("Lula", "PT", "??"),
            Politico("Bolsonaro", "Nazi", "??"),
            Politico("Ciro", "PDT", "??"),
            Politico("Joao", "PDJ", "??"),
        )
        DV_androidTheme() {
            FeedContent(politics)
        }
    }

    @Composable
    fun TopBar(){
        TopAppBar(backgroundColor = Color.Black) {
            val expanded = remember {
                mutableStateOf(false)
            }
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user_img",
                modifier = Modifier
                    .absolutePadding(right = 0.dp)
                    .clip(CircleShape)
                    .clickable { expanded.value = true }
                    .border(1.5.dp, Color.LightGray, CircleShape)
                    .size(40.dp)
            )

            Text(
                text = "DeuVoto",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(vertical = 10.dp),
                style = Typography.h3
            )

            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
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
    @Composable
    fun FeedContent(politicos: MutableList<Politico>){

        val clickFloatingButton = remember {
            mutableStateOf(false)
        }

        Scaffold(
            topBar = {
                TopBar()
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    clickFloatingButton.value = !clickFloatingButton.value
                }, backgroundColor = Color.Black)
                {
                    Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "left" )
                    if (clickFloatingButton.value) {
                        PoliticBar(politicos = politicos)
                    }
                }
            }
            /*
            bottomBar = {
                BottomAppBar(backgroundColor = Color.Black) {
                    PolitcBar(politicos = politicos)
                }
            }*/
        ) {
            LazyColumn(){
                items(5){
                    PoliticPost()
                }
                item {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = "Sem mais publicações",
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                    }
                }
            }
        }
    }
}

data class Politico(
    val name: String,
    val partido: String,
    val vice: String,
)


