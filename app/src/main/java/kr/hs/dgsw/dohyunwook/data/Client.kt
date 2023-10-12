package kr.hs.dgsw.dohyunwook.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {

    //서버 요청시간 정의
    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .writeTimeout(120, TimeUnit.SECONDS)
        .build()

    var gson = GsonBuilder().setLenient().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("192.168.11.15")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    val service: Service by lazy { retrofit.create(Service::class.java) }
}