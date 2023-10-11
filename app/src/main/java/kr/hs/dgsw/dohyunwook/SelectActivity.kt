package kr.hs.dgsw.dohyunwook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.hs.dgsw.dohyunwook.databinding.ActivitySelectBinding

class SelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.ivOne.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
        }
        binding.ivTwo.setOnClickListener {

        }
        binding.ivComu.setOnClickListener {

        }
    }
}