package kr.hs.dgsw.dohyunwook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.dohyunwook.databinding.ActivityIntroPageBinding
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeBinding

class OneMakeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, OneMakeOptionActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
        }
    }
}