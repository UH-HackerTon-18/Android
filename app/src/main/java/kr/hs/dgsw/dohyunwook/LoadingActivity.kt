package kr.hs.dgsw.dohyunwook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.dohyunwook.databinding.ActivityLoadingBinding
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeOptionBinding
import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter

class LoadingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val receivedIntent = intent
        val receivedData = receivedIntent.getSerializableExtra("data") as? RequestMakeCharacter
        if (receivedData != null) {
            val world = receivedData.world_story
            val characterCount = receivedData.character_count
            val character = receivedData.main_character
        }

    }
}