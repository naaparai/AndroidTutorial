package com.example.androidtutorial.roomdb.repo

import com.example.androidtutorial.roomdb.User

interface UserRepo {
    suspend fun insertUser(user: User)
    suspend fun getAllUser(): List<User>
}
