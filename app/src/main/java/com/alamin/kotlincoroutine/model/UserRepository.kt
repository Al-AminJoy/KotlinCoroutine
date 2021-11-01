package com.alamin.kotlincoroutine.model

import com.alamin.kotlincoroutine.model.User
import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers() : List<User>{
        delay(
            5000
        )
        val users : List<User> = listOf(
            User(1,"Al-Amim"),
            User(2,"Joy"),
            User(3,"Abul"),
            User(4,"Kabul"),
            User(5,"Bokul"),
            User(6,"Dodul"),
        )
        return users;
    }
}