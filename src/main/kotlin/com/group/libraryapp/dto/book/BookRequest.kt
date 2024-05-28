package com.group.libraryapp.dto.book

data class BookRequest(
    val name: String,
    val type: String,
) {
    init {
        val name = null
    }
}
