package com.ivanvegagonzalez.myapplication2frag.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Gatos(
    val title: String, val urlImagen: String, val descripcion: String, val origen: String, val pesoMin: Double,
    val pesoMax: Double, val tamanoMin: Double,val tamanoMax: Double,val esperamzaVidaMin: Double, val esperamzaVidaMax: Double, val colorPelaje: String, val tipoRaza: String ): Parcelable {
}