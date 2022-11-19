package com.ivanvegagonzalez.myapplication2frag.model.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {
    @GET("https://catbreeddb.p.rapidapi.com/")
    suspend fun popularMovies(@Query("rapidapi-key")apiKey: String): RemoteResult
}