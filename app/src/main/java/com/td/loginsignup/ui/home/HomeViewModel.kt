package com.td.loginsignup.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.td.loginsignup.data.network.Resource
import com.td.loginsignup.data.responses.LoginResponse
import com.td.loginsignup.data.respository.UserRepository
import com.td.loginsignup.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * ViewModel controlling Logged-in user experience between [HomeFragment] and [UserRepository]
 *
 * @property repository [UserRepository] class to persist user information
 */
class HomeViewModel(
  private val repository: UserRepository
): BaseViewModel(repository) {

  private val _user: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
  val user: LiveData<Resource<LoginResponse>>
  get() = _user

  fun getUser() = viewModelScope.launch {
    _user.value = repository.getUser()
  }
}