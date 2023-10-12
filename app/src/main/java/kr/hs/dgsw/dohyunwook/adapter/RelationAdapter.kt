package kr.hs.dgsw.dohyunwook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.dohyunwook.R
import kr.hs.dgsw.dohyunwook.domain.Relation

class RelationAdapter(private val items: List<Relation>) : RecyclerView.Adapter<RelationAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_relation, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.iv_item_chat_profile)
        private val itemNameText: TextView = itemView.findViewById(R.id.tv_item_chat_bot_name)
        private val itemExplainText: TextView = itemView.findViewById(R.id.tv_item_chat_text)

        fun bind(relation: Relation) {
            Glide.with(itemView.context).load(R.layout.item_relation).into(itemImage)
            itemNameText.text = relation.name
            itemExplainText.text = relation.explain
        }
    }
}
