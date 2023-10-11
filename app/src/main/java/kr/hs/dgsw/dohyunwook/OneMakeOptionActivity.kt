package kr.hs.dgsw.dohyunwook

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeOptionBinding

class OneMakeOptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeOptionBinding
    private var isMaleBackgroundReversed = false
    private var isFemaleBackgroundReversed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeOptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val receivedMessage = intent.getStringExtra("message_key")

        val initialMaleBackground: Drawable = resources.getDrawable(R.drawable.background_unselected_button, null)
        val reversedMaleBackground: Drawable = resources.getDrawable(R.drawable.background_selected_button, null)
        val initialFemaleBackground: Drawable = resources.getDrawable(R.drawable.background_unselected_button, null)
        val reversedFemaleBackground: Drawable = resources.getDrawable(R.drawable.background_selected_button, null)
        binding.btnMale.setOnClickListener {
            if ((!isMaleBackgroundReversed && !isFemaleBackgroundReversed) || (!isMaleBackgroundReversed && isFemaleBackgroundReversed)) {
                if (!isMaleBackgroundReversed) {
                    isMaleBackgroundReversed = true
                    binding.btnMale.background = reversedMaleBackground
                    isFemaleBackgroundReversed = false
                    binding.btnFemale.background = initialFemaleBackground
                }
            }
        }
        binding.btnFemale.setOnClickListener {
            if ((!isMaleBackgroundReversed && !isFemaleBackgroundReversed) || (isMaleBackgroundReversed && !isFemaleBackgroundReversed)) {
                if (!isFemaleBackgroundReversed) {
                    isFemaleBackgroundReversed = true
                    binding.btnFemale.background = reversedFemaleBackground
                    isMaleBackgroundReversed = false
                    binding.btnMale.background = initialMaleBackground
                }
            }
        }
        binding.btnStart.setOnClickListener {
            
        }
    }
}