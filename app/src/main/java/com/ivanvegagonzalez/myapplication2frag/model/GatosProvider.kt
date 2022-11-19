package com.ivanvegagonzalez.myapplication2frag.model

object GatosProvider {
    fun getGatos(tipo: String = "person"): List<Gatos> {
        Thread.sleep(2000)
        return (1..100).map {Gatos("Nombre $it","https://loremflickr.com/240/320/$tipo?lock=$it") }
    }
}