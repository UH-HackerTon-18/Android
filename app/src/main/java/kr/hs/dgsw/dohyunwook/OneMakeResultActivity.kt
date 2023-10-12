package kr.hs.dgsw.dohyunwook

import ImagePagerAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kr.hs.dgsw.dohyunwook.data.Client
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding
import kr.hs.dgsw.dohyunwook.domain.Relation
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoById
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

//        Client.service.getInfoByWorldId(worldID!!)
//                .enqueue(object : Callback<ResponseGetInfoByWorkldID> {
//                    override fun onResponse(
//                        call: Call<ResponseGetInfoByWorkldID>,
//                        response: Response<ResponseGetInfoByWorkldID>
//                    ) {
//                        if (response.isSuccessful) {
//                            val responseModel = response.body()
//                        } else {
//                            Log.d("onResponse:!!!!!!", response.errorBody().toString())
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseGetInfoByWorkldID>, t: Throwable) {
//
//                    }
//                })


        val imageUrls = listOf(
            "https://flexible.img.hani.co.kr/flexible/normal/850/556/imgdb/original/2023/1012/20231012500060.jpg",
            "https://flexible.img.hani.co.kr/flexible/normal/850/556/imgdb/original/2023/1012/20231012500060.jpg",
            "https://flexible.img.hani.co.kr/flexible/normal/850/556/imgdb/original/2023/1012/20231012500060.jpg"
        )
        val explains = listOf(
            "이것은 설명1",
            "이것은 설명2",
            "이것은 설명3"
        )
        val names = listOf(
            "이것은 이름1",
            "이것은 이름2",
            "이것은 이름3"
        )
        val relations = listOf(
            Relation("test123", "이것은 name1", "이것은 explain1"),
            Relation("test123", "이것은 name2", "이것은 explain2"),
            Relation("test123", "이것은 name3", "이것은 explain3"),
        )
        val pagerAdapter = ImagePagerAdapter(imageUrls, explains, names, relations)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // position은 현재 페이지의 위치입니다.
                // 이곳에서 position을 사용할 수 있습니다.
                Log.d("OneMakeResultActivity", "현재 position: $position")
            }
        })

        binding.viewPager.adapter = pagerAdapter

        binding.btnStart.setOnClickListener {
            val currentPosition = binding.viewPager.currentItem
            Log.d("OneMakeResultActivity", "현재 position: $currentPosition")
        }


    }
}