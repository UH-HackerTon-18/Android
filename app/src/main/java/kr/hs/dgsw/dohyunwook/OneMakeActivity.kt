package kr.hs.dgsw.dohyunwook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
            val message = binding.etSetTitle.text
            var number = binding.etCharacterNumber.text
            if (message.isEmpty()) {
                Toast.makeText(this, "세계관을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (number.isEmpty()) {
                Toast.makeText(this, "등장인물의 수를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, OneMakeOptionActivity::class.java)
            intent.putExtra("message_key", message.toString() + "세계")
            intent.putExtra("number", number.toString())
            startActivity(intent)
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}