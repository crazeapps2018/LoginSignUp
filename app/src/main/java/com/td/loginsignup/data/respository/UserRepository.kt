package com.td.loginsignup.data.respository

import com.td.loginsignup.data.network.UserApi

class UserRepository(
    private val api: UserApi,
): BaseRepository() {
    suspend fun getUser() = safeApiCall {
        api.getUser()
    }
}