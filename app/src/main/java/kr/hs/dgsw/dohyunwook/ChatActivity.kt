package kr.hs.dgsw.dohyunwook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.dgsw.dohyunwook.adapter.ChatAdapter
import kr.hs.dgsw.dohyunwook.databinding.ActivityChatBinding
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding
import kr.hs.dgsw.dohyunwook.domain.Chat

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    val chats = listOf<Chat>(Chat("안녕하세요", "네 반갑습니다", "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png", "도현욱"))

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val profileURL = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        binding.rvChat.adapter = ChatAdapter(chats)
        binding.rvChat.layoutManager = LinearLayoutManager(this)
    }
}