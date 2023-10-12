package kr.hs.dgsw.dohyunwook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.dohyunwook.R
import kr.hs.dgsw.dohyunwook.domain.Chat

class ChatAdapter(private val chats: MutableList<Chat>) : RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {

    // onCreateViewHolder, onBindViewHolder 및 getItemCount 함수는 이전과 동일하게 유지합니다.

    // 데이터 변경 시 RecyclerView 갱신을 위한 함수

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val botImage: ImageView = itemView.findViewById(R.id.iv_item_chat_bot_profile)
        private val botNameText: TextView = itemView.findViewById(R.id.tv_item_chat_bot_name)
        private val botMessage: TextView = itemView.findViewById(R.id.tv_item_chat_text_from_bot)
        private val userMessage: TextView = itemView.findViewById(R.id.tv_item_chat_from_me1)

        fun bind(chat: Chat) {
            Glide.with(itemView.context).load(chat.profile_image).into(botImage)
            botNameText.text = chat.name
            botMessage.text = chat.botTexts
            userMessage.text = chat.userTexts
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val chat = chats[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int {
        return chats.size
    }
}
