package com.example.androidtutorial.roomdb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtutorial.roomdb.repo.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayUserViewModel @Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {
    val usersMutableLiveData = MutableLiveData("")
    val imageMutableLiveData = MutableLiveData("")

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
