package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Schedule {

    @SerializedName("time")
    @Expose
    var time: String? = null
    @SerializedName("days")
    @Expose
    var days: List<String>? = null

}