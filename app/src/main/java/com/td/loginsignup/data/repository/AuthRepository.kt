package com.td.loginsignup.data.repository

import com.td.loginsignup.data.UserPreferences
import com.td.loginsignup.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository() {

  suspend fun login(
    email: String,
    password: String
  ) = safeApiCall {
    api.login(email, password)
  }

  suspend fun saveAuthToken(token: String) {
    preferences.saveAuthToken(token)
  }
}