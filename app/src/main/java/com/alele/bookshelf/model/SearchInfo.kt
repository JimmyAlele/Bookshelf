package com.alele.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class SearchInfo(
    val textSnippet: String
)