package com.ivanvegagonzalez.myapplication2frag.model.server

import com.google.gson.annotations.SerializedName

//class RemoteResult : ArrayList<RemoteResultItem>()

data class RemoteResult(
    val page: Int,
    val results: List<Gatos>,
   // @SerializedName("total_pages") val totalPages: Int,
   // @SerializedName("total_results") val totalResults: Int
)
data class Gatos(
    val breedDescription: String,
    @SerializedName("breedName")  val breedName: String,
    val breedType: String,
    val furColor: String,
    val id: Int,
    val imgAttribution: String,
    val imgCreativeCommons: Boolean,
    val imgSourceURL: String,
    @SerializedName("imgThumb") val imgThumb: String,
    val maxHeightInches: Double,
    val maxLifeSpan: Double,
    val maxWeightPounds: Double,
    val minHeightInches: Double,
    val minLifeSpan: Double,
    val minWeightPounds: Double,
    val origin: String
)