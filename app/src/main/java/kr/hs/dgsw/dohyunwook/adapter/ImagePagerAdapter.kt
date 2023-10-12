import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.dohyunwook.R
import kr.hs.dgsw.dohyunwook.adapter.RelationAdapter
import kr.hs.dgsw.dohyunwook.domain.Relation

class ImagePagerAdapter(private val resultImages: List<String>, private val explains: List<String>, private val names: List<String>, private val relations: List<List<Relation>>) : RecyclerView.Adapter<PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
        PagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false),resultImages, explains, names, relations)

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(position, holder.itemView.context)
    }

    override fun getItemCount(): Int = resultImages.size
}

class PagerViewHolder(itemView: View, private val resultImages: List<String>, private val explains: List<String>, private val names: List<String>, private val relations: List<List<Relation>>) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.tv_item_chrarctor_name)
    private val imageView: ImageView = itemView.findViewById(R.id.iv_image222)
    private val explainTextView: TextView = itemView.findViewById(R.id.tv_item_explane_text)
    private val relationsRV: RecyclerView = itemView.findViewById(R.id.rv_relation)
    private val insta: ImageView = itemView.findViewById(R.id.btn_insta)

    fun bind(position: Int, context: Context) {
        Glide.with(context).load(resultImages[position]).into(imageView)
        nameTextView.text = names[position]
        explainTextView.text = explains[position]
        relationsRV.adapter = RelationAdapter(relations[position])
        relationsRV.layoutManager = LinearLayoutManager(context)
        insta.setOnClickListener {
            shareLink(context, resultImages[position])
        }
    }

    fun shareLink(context: Context, linkUrl: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, linkUrl)

        val chooser = Intent.createChooser(shareIntent, "Share link via...")
        if (shareIntent.resolveActivity(context.packageManager) != null) {
            context.startActivity(chooser)
        }
    }
}

