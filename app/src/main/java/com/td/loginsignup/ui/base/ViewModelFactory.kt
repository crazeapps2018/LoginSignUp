package com.td.loginsignup.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.td.loginsignup.ui.auth.AuthViewModel
import com.td.loginsignup.ui.home.HomeViewModel
import com.td.loginsignup.data.respository.AuthRepository
import com.td.loginsignup.data.respository.BaseRepository
import com.td.loginsignup.data.respository.UserRepository

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("Class Not found")
        }
    }
}