package kr.hs.dgsw.dohyunwook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding

class OneMakeResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val characterID = intent.getStringExtra("message_key")

    }
}