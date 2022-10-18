package com.ivanvegagonzalez.myapplication2frag.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Conctato(val title: String, val telefono: String, val correo: String, val urlImagen: String): Parcelable {
}