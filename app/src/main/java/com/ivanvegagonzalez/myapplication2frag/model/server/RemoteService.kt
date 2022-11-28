package com.ivanvegagonzalez.myapplication2frag.model.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {
    @GET("?rapidapi-key=99728e8d1fmsh34d885dddff5ba7p15b730jsn1893e61c2e22")
    //suspend fun gatos(@Query("rapidapi-key")apiKey: String): RemoteResult
    suspend fun gatos(): RemoteResult
}