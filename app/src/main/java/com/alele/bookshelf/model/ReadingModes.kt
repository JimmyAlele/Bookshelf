package com.alele.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class ReadingModes(
    val text: Boolean,
    val image: Boolean
)