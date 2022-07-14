package com.dzikril.suitmediatest.ui.listuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.dzikril.suitmediatest.local.UsersRemoteMediator
import com.dzikril.suitmediatest.local.entity.Users
import com.dzikril.suitmediatest.local.room.UsersDatabase
import com.dzikril.suitmediatest.retrofit.ApiService

class ListUserViewModel (private val apiService: ApiService, private val usersDatabase: UsersDatabase): ViewModel() {

    fun getUsers(): LiveData<PagingData<Users>>{
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
                config = PagingConfig(
                    pageSize = 5
                ),
                remoteMediator = UsersRemoteMediator(usersDatabase, apiService),
                pagingSourceFactory = {
                    usersDatabase.userDao().getAllUsers()
                }
            ).liveData
    }
}