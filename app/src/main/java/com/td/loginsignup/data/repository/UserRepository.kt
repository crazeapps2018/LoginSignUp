package com.td.loginsignup.data.repository

import com.td.loginsignup.data.network.UserApi
import com.td.loginsignup.data.repository.BaseRepository

class UserRepository(
    private val api: UserApi,
) : BaseRepository() {

 suspend fun getUser() = safeApiCall {
   api.getUser()

 }
}
