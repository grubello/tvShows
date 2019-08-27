package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("self")
    @Expose
    var self: Self? = null
    @SerializedName("previousepisode")
    @Expose
    var previousepisode: PreviousEpisode? = null

}