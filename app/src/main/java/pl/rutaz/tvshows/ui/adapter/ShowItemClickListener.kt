package pl.rutaz.tvshows.ui.adapter

import pl.rutaz.tvshows.model.api.Show

interface ShowItemClickListener {
    fun onClick(show: Show)
}