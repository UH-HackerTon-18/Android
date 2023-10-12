package kr.hs.dgsw.dohyunwook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.dohyunwook.R
import kr.hs.dgsw.dohyunwook.domain.Chat

class ChatAdapter(private val myMessage: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = myMessage[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return myMessage.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val botImage: ImageView = itemView.findViewById(R.id.iv_item_chat_bot_profile)
        private val botNameText: TextView = itemView.findViewById(R.id.tv_item_chat_bot_name)
        private val botMessage: TextView = itemView.findViewById(R.id.tv_item_chat_text_from_bot)
        private val userMessage: TextView = itemView.findViewById(R.id.tv_item_chat_from_me1)
        fun bind(chat: Chat) {
            Glide.with(itemView.context).load("https://flexible.img.hani.co.kr/flexible/normal/640/828/imgdb/child/2023/1012/16970864058927_20231012501437.jpg").into(botImage)
            botNameText.text = chat.name
            botMessage.text = chat.botTexts
            userMessage.text = chat.userTexts
        }
    }
}