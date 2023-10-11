package kr.hs.dgsw.dohyunwook

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeOptionBinding
import kr.hs.dgsw.dohyunwook.domain.MainCharacter
import kr.hs.dgsw.dohyunwook.domain.RequestMakeCharacter

class OneMakeOptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOneMakeOptionBinding
    private var isMaleBackgroundReversed = true
    private var isFemaleBackgroundReversed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneMakeOptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val receivedMessage = intent.getStringExtra("message_key")
        val intent = Intent(this, LoadingActivity::class.java)
        var male = "남자"
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
                    male = "남자"
                }
            }

        }
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnFemale.setOnClickListener {
            if ((!isMaleBackgroundReversed && !isFemaleBackgroundReversed) || (isMaleBackgroundReversed && !isFemaleBackgroundReversed)) {
                if (!isFemaleBackgroundReversed) {
                    isFemaleBackgroundReversed = true
                    binding.btnFemale.background = reversedFemaleBackground
                    isMaleBackgroundReversed = false
                    binding.btnMale.background = initialMaleBackground
                    male = "여자"
                }
            }
        }
        binding.btnStart.setOnClickListener {
            val age = binding.etOld.text
            val backGroundStory = binding.etBackgroundStory.text
            val character = binding.etCharacter.text
            var characterNumber = binding.etCharacterNumber.text
            val species = binding.etSpecies.text
            val speciesExplain = binding.etSpeciesExplain.text
            val name = binding.etName.text
            val style = binding.etStyle.text
            val title = receivedMessage
            if (characterNumber.toString().isNullOrEmpty()) {
                characterNumber = Editable.Factory.getInstance().newEditable("1")
            }
            val requestMakeCharacter:RequestMakeCharacter = RequestMakeCharacter(
                title.toString(),
                MainCharacter(
                    name.toString(),
                    male,
                    age.toString(),
                    species.toString(),
                    speciesExplain.toString(),
                    style.toString(),
                    character.toString(),
                    backGroundStory.toString()
                ),
                characterNumber.toString().toInt()
            )
            intent.putExtra("data", requestMakeCharacter)
            startActivity(intent)
        }
    }
}