package com.example.dv_android.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dv_android.models.User
import com.example.dv_android.utils.userService
import kotlinx.coroutines.launch

class AnotherViewModel : ViewModel() {

    /*
    val myResponseList: MutableLiveData<List<User>> = MutableLiveData()

    var myResponseUser: User = User("Jeff","jeff@email", "jeff@email")

    fun getUser(){
        viewModelScope.launch {
            myResponseList.value = userService.getUsers()
        }
    }
     */
}