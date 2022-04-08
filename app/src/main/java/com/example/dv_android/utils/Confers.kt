package com.example.dv_android.utils

fun isAPassword(password: String) : Boolean{
    return password.length >= 8
}

fun isAEmail(email: String): Boolean{
    if(
        email.contains("@") &&
        email.contains(".com") &&
        email.length > 1
    ){
        return true
    }
    return false
}

fun isAName(name: String) : Boolean{
    return name.length > 1
}