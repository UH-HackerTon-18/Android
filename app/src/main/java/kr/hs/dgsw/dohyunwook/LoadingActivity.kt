package kr.hs.dgsw.dohyunwook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
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

        val world = receivedData!!.world_story
        val characterCount = receivedData!!.character_count
        val character = receivedData!!.main_character

        Thread(Runnable {
//            Client.characterService.postData(receivedData!!)
//                .enqueue(object : Callback<ResponseMakeCharacter> {
//                    override fun onResponse(
//                        call: Call<ResponseMakeCharacter>,
//                        response: Response<ResponseMakeCharacter>
//                    ) {
//                        if (response.isSuccessful) {
//                            val responseModel = response.body()
//                            val intent = Intent(applicationContext, OneMakeResultActivity::class.java)
//                            intent.putExtra("message_key", responseModel!!.world_id)
//                            startActivity(intent)
//                        } else {
//                            Log.d("onResponse:!!!!!!", response.errorBody().toString())
//                            // response.errorBody() 등을 통해 오류 상세 정보를 얻을 수 있음
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseMakeCharacter>, t: Throwable) {
//
//                    }
//                })
            val needTime:Int = (characterCount * 13 * 1000)
            for (progress in 0..100) {
                // UI 업데이트를 위해 Handler를 사용
                Handler(Looper.getMainLooper()).post {
                    binding.progressBar.progress = progress
                }

                // 100ms마다 업데이트
                try {
                    Thread.sleep((needTime / 100).toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            val intent = Intent(applicationContext, OneMakeResultActivity::class.java)
            startActivity(intent)
        }).start()
    }
}
