package pl.rutaz.tvshows.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.rutaz.tvshows.R
import pl.rutaz.tvshows.model.api.Show
import pl.rutaz.tvshows.ui.adapter.ShowItemClickListener
import pl.rutaz.tvshows.ui.adapter.ShowListAdapter
import pl.rutaz.tvshows.util.Constants
import pl.rutaz.tvshows.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), ShowItemClickListener {

    private val adapter: ShowListAdapter by lazy {
        ShowListAdapter(this)
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.showList.observe(this, Observer {
            if (it.isEmpty()) {
                noResultTextView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                noResultTextView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                adapter.showList = it
                adapter.notifyDataSetChanged()
            }
        })

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) viewModel.processQuery(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
        })

        searchView.setIconifiedByDefault(false)
    }

    override fun onClick(show: Show) {
        Intent(this, PlayerActivity::class.java).also {
            it.putExtra(Constants.videoUriKey, Constants.videoUrl)
            startActivity(it)
        }
    }
}
