import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.dohyunwook.R
import kr.hs.dgsw.dohyunwook.domain.Relation

class ImagePagerAdapter(private val resultImages: List<String>, private val explains: List<String>, private val names: List<String>, private val relations: List<Relation>) : RecyclerView.Adapter<PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false),resultImages, explains, names, relations)

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = resultImages.size
}

class PagerViewHolder(itemView: View, private val resultImages: List<String>, private val explains: List<String>, private val names: List<String>, private val relations: List<Relation>) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.tv_item_chrarctor_name)
    private val imageView: ImageView = itemView.findViewById(R.id.iv_image222)
    private val explainTextView: TextView = itemView.findViewById(R.id.tv_item_explane_text)
    fun bind(position: Int) {
        Glide.with(itemView.context).load(resultImages[position]).into(imageView)
        nameTextView.text = names[position]
        explainTextView.text = explains[position]
    }
}
