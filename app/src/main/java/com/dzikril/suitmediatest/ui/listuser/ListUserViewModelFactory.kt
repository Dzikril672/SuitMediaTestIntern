package com.dzikril.suitmediatest.ui.listuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzikril.suitmediatest.local.room.UsersDatabase
import com.dzikril.suitmediatest.retrofit.ApiService

class ListUserViewModelFactory constructor(private val apiService: ApiService, private val usersDatabase: UsersDatabase) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListUserViewModel::class.java) -> {
                ListUserViewModel(apiService, usersDatabase) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
            }
        }
    }
}