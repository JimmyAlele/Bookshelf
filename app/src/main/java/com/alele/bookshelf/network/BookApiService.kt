package com.alele.bookshelf.network

import com.alele.bookshelf.BuildConfig
import com.alele.bookshelf.model.AllData
import retrofit2.http.GET

/**
 * A public interface that exposes the [getAllBookData] method
 */
interface BookApiService {
    /**
     * Returns all the book data and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "" endpoint will be requested with the GET
     * HTTP method example
     * @GET("volumes?q=jetpack+compose&key=${BuildConfig.API_KEY}")
     */
    @GET("volumes?q=cat&key=${BuildConfig.API_KEY}")
    suspend fun getAllBookData(): AllData

}