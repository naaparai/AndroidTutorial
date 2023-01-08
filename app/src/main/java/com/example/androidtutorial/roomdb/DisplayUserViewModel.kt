package com.example.androidtutorial.roomdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtutorial.roomdb.repo.UserRepo
import kotlinx.coroutines.launch

class DisplayUserViewModel : ViewModel() {
    val usersMutableLiveData = MutableLiveData("")
    val imageMutableLiveData = MutableLiveData("")
    lateinit var userRepo: UserRepo
    fun initUserRepo(userRepo: UserRepo) {
        this.userRepo = userRepo
    }

    fun load() {
        imageMutableLiveData.postValue("https://picsum.photos/200/300")
        viewModelScope.launch {
            val users = userRepo.getAllUser()
            val sb = StringBuilder()
            users.forEach {
                sb.append("${it.firstName} ${it.lastName}")
                sb.append("\n")
            }
            usersMutableLiveData.postValue(sb.toString())
        }
    }
}
