package com.alele.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    val isAvailable: Boolean,
    val acsTokenLink: String? = null
)