package kr.hs.dgsw.dohyunwook.data

import kr.hs.dgsw.dohyunwook.domain.ChatRequest
import kr.hs.dgsw.dohyunwook.domain.ChatResponse
import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoById
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoByWorkldID
import kr.hs.dgsw.dohyunwook.domain.ResponseMakeCharacter
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @POST("characters/")
    fun postData(@Body requestBody: RequestMakeCharacter): Call<ResponseMakeCharacter>

    @GET("characters/world/{world-id}")
    fun getInfoByWorldId(@Path("world-id") id: String): Call<ResponseGetInfoByWorkldID>

    @GET("characters/")
    fun getInfoById(@Path("character-id") id: String): Call<ResponseGetInfoById>

    @POST("/characters/chat/{character-id}")
    fun postChat(@Path("character-id") id: String, @Body message: ChatRequest): Call<ChatResponse>

}