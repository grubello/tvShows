package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Externals {

    @SerializedName("tvrage")
    @Expose
    var tvrage: Int? = null
    @SerializedName("thetvdb")
    @Expose
    var thetvdb: Int? = null
    @SerializedName("imdb")
    @Expose
    var imdb: String? = null

}