package com.td.loginsignup.data.network

import com.td.loginsignup.data.responses.LoginResponse
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

  @GET("user")
  suspend fun getUser(): LoginResponse

  @POST("logout")
  suspend fun logout(): ResponseBody
}