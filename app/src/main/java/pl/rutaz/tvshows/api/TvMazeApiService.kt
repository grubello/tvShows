package pl.rutaz.tvshows.api

import io.reactivex.Observable
import pl.rutaz.tvshows.model.api.Show
import retrofit2.http.GET
import retrofit2.http.Query

interface TvMazeApiService {

    @GET("/search/shows?")
    fun getShows(@Query("q") searchText: String): Observable<List<Show>>
}