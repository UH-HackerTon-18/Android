package kr.hs.dgsw.dohyunwook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.dohyunwook.databinding.ActivityIntroPageBinding

class IntroPage : AppCompatActivity() {
    private lateinit var binding: ActivityIntroPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, OneMakeActivity::class.java))
        }
    }
}