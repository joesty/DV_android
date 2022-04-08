package com.example.dv_android.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import com.example.dv_android.viewmodels.AnotherViewModel
import com.example.dv_android.models.User

class AnotherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        val viewModel: AnotherViewModel by viewModels()
        val users = mutableStateListOf<User>()
        viewModel.getUser()
        viewModel.myResponseList.observe(this,){
            for(user in it){
                users.add(user)
            }
        }
        setContent {
            content(users = users)
        }
         */
    }
    @Composable
    fun content(users:List<User>){
        LazyColumn(){
            items(users){ user ->
                Text(text = user.name)
                Text(text = user.email)
            }
        }
    }
}