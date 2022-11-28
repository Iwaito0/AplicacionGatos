package com.ivanvegagonzalez.myapplication2frag.model.server

data class Gatos(
    val breedDescription: String,
    val breedName: String,
    val breedType: String,
    val furColor: String,
    val id: Int,
    val imgAttribution: String,
    val imgCreativeCommons: Boolean,
    val imgSourceURL: String,
    val imgThumb: String,
    val maxHeightInches: Double,
    val maxLifeSpan: Double,
    val maxWeightPounds: Double,
    val minHeightInches: Double,
    val minLifeSpan: Double,
    val minWeightPounds: Double,
    val origin: String
)