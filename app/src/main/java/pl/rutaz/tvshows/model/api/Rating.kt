package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rating {

    @SerializedName("average")
    @Expose
    var average: Double? = null

}