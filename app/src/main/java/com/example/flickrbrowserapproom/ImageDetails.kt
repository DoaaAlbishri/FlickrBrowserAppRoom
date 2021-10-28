package com.example.flickrbrowserapproom

import com.google.gson.annotations.SerializedName

class ImageDetails {

    @SerializedName("photos")
    var photos: Photos? = null

    class Photos {

        @SerializedName("photo")
        var photo: Array<Photo>? = null

        class Photo {
            @SerializedName("title")
            var title: String? = null

            @SerializedName("id")
            var id: String? = null

            @SerializedName("secret")
            var secret: String? = null

            @SerializedName("server")
            var server: String? = null

            @SerializedName("farm")
            var farm: String? = null
        }
    }
}