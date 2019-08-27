package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Show {

    @SerializedName("score")
    @Expose
    var score: Double? = null
    @SerializedName("show")
    @Expose
    var showDetails: ShowDetails? = null

}