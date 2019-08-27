package pl.rutaz.tvshows.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ShowDetails {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("genres")
    @Expose
    var genres: List<String>? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("runtime")
    @Expose
    var runtime: Int? = null
    @SerializedName("premiered")
    @Expose
    var premiered: String? = null
    @SerializedName("officialSite")
    @Expose
    var officialSite: Any? = null
    @SerializedName("schedule")
    @Expose
    var schedule: Schedule? = null
    @SerializedName("rating")
    @Expose
    var rating: Rating? = null
    @SerializedName("weight")
    @Expose
    var weight: Int? = null
    @SerializedName("network")
    @Expose
    var network: Network? = null
    @SerializedName("webChannel")
    @Expose
    var webChannel: Any? = null
    @SerializedName("externals")
    @Expose
    var externals: Externals? = null
    @SerializedName("image")
    @Expose
    var image: Image? = null
    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("updated")
    @Expose
    var updated: Int? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}