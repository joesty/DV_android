package com.example.dv_android.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dv_android.models.User
import com.example.dv_android.utils.userService
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {

    /* Use This for production
    fun saveUser(user:User){
        viewModelScope.launch {
            userService.saveUser(user)
        }
    }
    */


}