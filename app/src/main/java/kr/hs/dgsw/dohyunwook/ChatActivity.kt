package kr.hs.dgsw.dohyunwook

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.dgsw.dohyunwook.adapter.ChatAdapter
import kr.hs.dgsw.dohyunwook.data.Client
import kr.hs.dgsw.dohyunwook.databinding.ActivityChatBinding
import kr.hs.dgsw.dohyunwook.domain.Chat
import kr.hs.dgsw.dohyunwook.domain.ChatRequest
import kr.hs.dgsw.dohyunwook.domain.ChatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    var chats = mutableListOf<Chat>()
    private lateinit var chatAdapter: ChatAdapter // ChatAdapter 변수 추가

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        val view = binding.root
        val id = intent.getStringExtra("id")
        setContentView(view)
        val profileURL = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        binding.logo.text = name
        chatAdapter = ChatAdapter(chats) // ChatAdapter 초기화
        binding.rvChat.adapter = chatAdapter
        var botChat: String
        binding.rvChat.layoutManager = LinearLayoutManager(this)
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnSend.setOnClickListener {
            val text = binding.etChat.text.toString()
            binding.etChat.text.clear()
            chats.add(Chat("", text, "", ""))
            chatAdapter.notifyDataSetChanged()
            Client.service.postChat(id!!, ChatRequest(text))
                .enqueue(object : Callback<ChatResponse> {
                    override fun onResponse(
                        call: Call<ChatResponse>,
                        response: Response<ChatResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("onResponse: 성공", "${response.body()}")
                            val responseModel = response.body()
                            botChat = responseModel!!.response

                            var chat = Chat(
                                botChat,
                                text,
                                profileURL!!,
                                name!!
                            )
                            chats.removeAt(chats.size - 1)
                            chats.add(chat)
                            chatAdapter.notifyDataSetChanged()   // 어댑터에 데이터 변경 알림
                        } else {
                            val errorBodyString = response.errorBody()?.string()
                            Log.d("Error Response Body", errorBodyString ?: "Empty error body")
                        }
                    }

                    override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                        Log.d("onResponse:", "실패")
                    }
                })
        }
    }
}

