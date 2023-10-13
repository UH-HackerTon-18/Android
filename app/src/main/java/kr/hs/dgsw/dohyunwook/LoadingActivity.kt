package kr.hs.dgsw.dohyunwook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
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
        val intent = Intent(this, OneMakeResultActivity::class.java)
        val world = receivedData!!.world_story
        val characterCount = receivedData!!.character_count
        val character = receivedData!!.main_character

        Client.service.postData(receivedData!!)
            .enqueue(object : Callback<ResponseMakeCharacter> {
                override fun onResponse(
                    call: Call<ResponseMakeCharacter>,
                    response: Response<ResponseMakeCharacter>
                ) {
                    if (response.isSuccessful) {
                        Log.d("onResponse: @@@@@@@@@@@@@", "성공")
                        val responseModel = response.body()
                        val intent = Intent(applicationContext, OneMakeResultActivity::class.java)
                        intent.putExtra("message_key", responseModel!!.world_id)
                        startActivity(intent)
                    } else {
                        Log.d("onResponse:!!!!!!", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<ResponseMakeCharacter>, t: Throwable) {
                    Log.d("onFailure: ", "###########")
                    Toast.makeText(applicationContext, "네트워크 오류", Toast.LENGTH_SHORT).show()
                }
            })

        Thread(Runnable {
            Log.d(
                "onCreate:!!!!!!!!!!!@ ",
                "${receivedData.world_story}  ${receivedData.character_count}   ${receivedData.main_character?.species}"
            )
            val needTime: Int = (characterCount * 20 * 1000) + 60 * 1000
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
        }).start()
    }
}
