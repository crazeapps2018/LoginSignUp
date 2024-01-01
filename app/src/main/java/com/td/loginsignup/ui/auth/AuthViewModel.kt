package com.td.loginsignup.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.td.loginsignup.data.network.Resource
import com.td.loginsignup.data.responses.LoginResponse
import com.td.loginsignup.data.respository.AuthRepository
import com.td.loginsignup.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class AuthViewModel(
  private val repository: AuthRepository
): BaseViewModel(repository) {

  private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
  val loginResponse: LiveData<Resource<LoginResponse>> get() = _loginResponse

  fun login(
    email: String,
    password: String) = viewModelScope.launch {
      _loginResponse.value = repository.login(email, password)
  }

  suspend fun saveAuthToken(token: String) {
    repository.saveAuthToken(token)
  }

}