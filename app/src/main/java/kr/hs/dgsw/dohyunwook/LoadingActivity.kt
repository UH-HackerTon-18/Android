package kr.hs.dgsw.dohyunwook

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kr.hs.dgsw.dohyunwook.data.Client
import kr.hs.dgsw.dohyunwook.databinding.ActivityLoadingBinding
import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter
import kr.hs.dgsw.dohyunwook.domain.ResponseMakeCharacter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        binding.progressBar.bringToFront()
        val view = binding.root
        setContentView(view)
        val receivedIntent = intent
        val receivedData = receivedIntent.getSerializableExtra("data") as? RequestMakeCharacter
        if (receivedData != null) {
            val world = receivedData.world_story
            val characterCount = receivedData.character_count
            val character = receivedData.main_character
        }
        Thread(Runnable {
//            Client.characterService.postData(receivedData!!)
//                .enqueue(object : Callback<ResponseMakeCharacter> {
//                    override fun onResponse(
//                        call: Call<ResponseMakeCharacter>,
//                        response: Response<ResponseMakeCharacter>
//                    ) {
//                        if (response.isSuccessful) {
//                            val responseModel = response.body()
//                            // 성공 처리
//                        } else {
//                            // 오류 처리
//                            // response.errorBody() 등을 통해 오류 상세 정보를 얻을 수 있음
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseMakeCharacter>, t: Throwable) {
//                        // 요청 실패 시 수행할 작업
//                    }
//                })

            for (progress in 0..100) {
                // UI 업데이트를 위해 Handler를 사용
                Handler(Looper.getMainLooper()).post {
                    binding.progressBar.progress = progress
                }

                // 100ms마다 업데이트
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }

        }).start()
    }
}
