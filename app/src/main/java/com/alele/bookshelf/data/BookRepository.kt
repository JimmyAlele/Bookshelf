package com.alele.bookshelf.data

import com.alele.bookshelf.model.AllData
import com.alele.bookshelf.network.BookApiService

/**
 * Repository that fetch book list from bookApi.
 */
interface BookRepository {
    /** Fetches list of books from bookApi */
    suspend fun getAllBookData(): AllData
}

/**
 * Network Implementation of Repository that fetch book list from bookApi.
 */
class NetworkBookRepository(
    private val bookApiService: BookApiService
) : BookRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getAllBookData(): AllData = bookApiService.getAllBookData()
}