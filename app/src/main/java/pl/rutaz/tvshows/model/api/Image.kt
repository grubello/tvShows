package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {

    @SerializedName("medium")
    @Expose
    var medium: String? = null
    @SerializedName("original")
    @Expose
    var original: String? = null

}