package kr.hs.dgsw.dohyunwook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OneMakeOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_make_option)
        val receivedMessage = intent.getStringExtra("message_key")

    }
}