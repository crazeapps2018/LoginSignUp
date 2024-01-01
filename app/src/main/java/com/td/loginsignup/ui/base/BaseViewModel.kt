package com.td.loginsignup.ui.base

import androidx.lifecycle.ViewModel
import com.td.loginsignup.data.network.UserApi
import com.td.loginsignup.data.respository.AuthRepository
import com.td.loginsignup.data.respository.BaseRepository

abstract class BaseViewModel(private val repository: BaseRepository):ViewModel() {
    suspend fun logout(api: UserApi) = repository.logout(api)
}