package kr.hs.dgsw.dohyunwook

import ImagePagerAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kr.hs.dgsw.dohyunwook.data.Client
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoByWorkldID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OneMakeResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val worldID = intent.getStringExtra("message_key")
        var imageUr = listOf<String>()
        var name = listOf<String>()
        binding.btnBack.setOnClickListener {
            val intent = Intent(applicationContext, IntroPage::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        Client.service.getInfoByWorldId(worldID!!)
            .enqueue(object : Callback<ResponseGetInfoByWorkldID> {
                override fun onResponse(
                    call: Call<ResponseGetInfoByWorkldID>,
                    response: Response<ResponseGetInfoByWorkldID>
                ) {
                    if (response.isSuccessful) {
                        Log.d("onResponse: 성공", "${response.body()}")
                        val responseModel = response.body()
                        val imageUrls = responseModel!!.characters.map { it.profile_image_url }
                        imageUr = imageUrls
                        val explains = responseModel!!.characters.map { it.name + "\n" + it.gender + "\n" + it.age + "\n" + it.job + "\n" + it.character}
                        val names = responseModel!!.characters.map { it.name }
                        name = names
                        val relations = responseModel!!.characters.map { it.relation }
                        val pagerAdapter = ImagePagerAdapter(imageUrls, explains, names, relations)
                        binding.viewPager.adapter = pagerAdapter
                    } else {
                        val errorBodyString = response.errorBody()?.string()
                        Log.d("Error Response Body", errorBodyString ?: "Empty error body")
                    }
                }

                override fun onFailure(call: Call<ResponseGetInfoByWorkldID>, t: Throwable) {
                    Log.d("onResponse:", "실패")
                }
            })



        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // position은 현재 페이지의 위치입니다.
                // 이곳에서 position을 사용할 수 있습니다.
                Log.d("OneMakeResultActivity", "현재 position: $position")
            }
        })



        binding.btnStart.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            val currentPosition = binding.viewPager.currentItem
            intent.putExtra("image", imageUr[currentPosition])
            intent.putExtra("name", name[currentPosition])
            Log.d("OneMakeResultActivity", "현재 position: $currentPosition")
            startActivity(intent)
        }
    }
}