package com.example.androidtutorial.roomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtutorial.roomdb.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertViewModel @Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {
    fun insertUser(user: User) {
        viewModelScope.launch {
            userRepo.insertUser(user)
        }
    }
}
