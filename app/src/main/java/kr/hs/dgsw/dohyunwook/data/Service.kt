package kr.hs.dgsw.dohyunwook.data

import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoById
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoByWorkldID
import kr.hs.dgsw.dohyunwook.domain.ResponseMakeCharacter
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Service {
    @POST("/")
    fun postData(@Body requestBody: RequestMakeCharacter): Call<ResponseMakeCharacter>

    @GET("/world/")
    fun getInfoByWorldId(@Query("world-id") id: String): Call<ResponseGetInfoByWorkldID>

    @GET("/")
    fun getInfoById(@Query("character-id") id: String): Call<ResponseGetInfoById>
}