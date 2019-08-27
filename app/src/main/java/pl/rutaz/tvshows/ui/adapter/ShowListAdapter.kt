package pl.rutaz.tvshows.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.rutaz.tvshows.R
import pl.rutaz.tvshows.model.api.Show

class ShowListAdapter(private val clickListener: ShowItemClickListener) : RecyclerView.Adapter<ShowListViewHolder>() {

    var showList: List<Show> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowListViewHolder {
        return ShowListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.show_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return showList.size
    }

    override fun onBindViewHolder(holder: ShowListViewHolder, position: Int) {
        holder.populate(showList[position], clickListener)
    }

}