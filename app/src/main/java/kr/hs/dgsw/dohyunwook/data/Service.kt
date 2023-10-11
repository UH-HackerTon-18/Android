package kr.hs.dgsw.dohyunwook.data

import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter
import kr.hs.dgsw.dohyunwook.domain.ResponseMakeCharacter
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {
    @POST("/")
    fun postData(@Body requestBody: RequestMakeCharacter): Call<ResponseMakeCharacter>
}