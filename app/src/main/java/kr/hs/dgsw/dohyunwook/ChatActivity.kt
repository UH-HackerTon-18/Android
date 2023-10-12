package kr.hs.dgsw.dohyunwook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}