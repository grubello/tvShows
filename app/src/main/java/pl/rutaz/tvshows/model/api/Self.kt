package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Self {

    @SerializedName("href")
    @Expose
    var href: String? = null

}