package com.example.marvelcadu.data.remote

import com.example.marvelcadu.data.model.character.CharacterModelResponse
import com.example.marvelcadu.data.model.comic.ComicModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("characters")
    suspend fun list(
        @Query("nameStartsWith") nameStartsWith: String? = null
    ): Response<CharacterModelResponse>

    @GET("character/{characterId}/comics")
    suspend fun getComics(
        @Path(
            value = "characterId",
            encoded = true
        )characterId: Int
    ): Response<ComicModelResponse>
}