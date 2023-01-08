package com.example.androidtutorial.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtutorial.roomdb.repo.UserRepo
import kotlinx.coroutines.launch

class InsertViewModel : ViewModel() {
    lateinit var userRepo: UserRepo
    fun initRepo(userRepo: UserRepo) {
        this.userRepo = userRepo
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepo.insertUser(user)
        }
    }
}
