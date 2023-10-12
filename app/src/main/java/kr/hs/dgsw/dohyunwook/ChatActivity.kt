package kr.hs.dgsw.dohyunwook

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kr.hs.dgsw.dohyunwook.adapter.ChatAdapter
import kr.hs.dgsw.dohyunwook.data.Client
import kr.hs.dgsw.dohyunwook.databinding.ActivityChatBinding
import kr.hs.dgsw.dohyunwook.databinding.ActivityOneMakeResultBinding
import kr.hs.dgsw.dohyunwook.domain.Chat
import kr.hs.dgsw.dohyunwook.domain.ChatRequest
import kr.hs.dgsw.dohyunwook.domain.ChatResponse
import kr.hs.dgsw.dohyunwook.domain.ResponseGetInfoByWorkldID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    var chats = mutableListOf<Chat>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        val view = binding.root
        val id = intent.getStringExtra("id")
        setContentView(view)
        val profileURL = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        binding.rvChat.adapter = ChatAdapter(chats)
        var botChat: String
        binding.rvChat.layoutManager = LinearLayoutManager(this)
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnSend.setOnClickListener {

            Client.service.postChat(id!!, ChatRequest(binding.etChat.text.toString()))
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
                                binding.etChat.text.toString(),
                                profileURL!!,
                                name!!
                            )
                            chats.add(chat) // 데이터 추가
                            Log.d("onCreate: chats", "$chats")
                            binding.rvChat.adapter?.notifyDataSetChanged()
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

