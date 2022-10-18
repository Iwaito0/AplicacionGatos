package com.ivanvegagonzalez.myapplication2frag.model

object ConctatosProvider {
    fun getConctatos(tipo: String = "person"): List<Conctato> {
        Thread.sleep(2000)
        return (1..100).map {Conctato("Nombre $it", "95512212$it","noseque@gmail.com$it","https://loremflickr.com/240/320/$tipo?lock=$it") }
    }
}