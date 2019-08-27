package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Network {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("country")
    @Expose
    var country: Country? = null

}