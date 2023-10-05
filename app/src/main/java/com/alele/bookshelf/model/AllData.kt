package com.alele.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class AllData(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>
)