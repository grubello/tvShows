package pl.rutaz.tvshows.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.show_item_view.view.*
import pl.rutaz.tvshows.R
import pl.rutaz.tvshows.model.api.Show
import java.util.*

class ShowListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val posterImageView: ImageView = itemView.posterImageView
    private val titleView: TextView = itemView.showTitleTextView
    private val categoryView: TextView = itemView.showCategoryTextView
    private var category: String = ""

    fun populate(show: Show, clickListener: ShowItemClickListener) {

        val genres: List<String> = show.showDetails?.genres ?: ArrayList()

        if (genres.isEmpty()) {
            category = "No category available"
        } else {
            for (genre: String in genres) {
                category += " $genre "
            }
        }

        categoryView.text = category
        titleView.text = show.showDetails?.name ?: "No name available"

        Picasso.get().load(show.showDetails?.image?.medium).placeholder(R.drawable.ic_poster_placeholder)
            .into(posterImageView)

        itemView.setOnClickListener { clickListener.onClick(show) }
    }
}