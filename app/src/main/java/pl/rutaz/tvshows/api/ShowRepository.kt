package pl.rutaz.tvshows.api

import io.reactivex.Observable
import pl.rutaz.tvshows.model.api.Show

class ShowRepository {

    fun getShows(queryText: String): Observable<List<Show>> {
        return RetrofitService.service.getShows(queryText)
    }

}