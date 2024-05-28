package com.group.libraryapp.dto.book

data class BookRequest(
    val name: String?
) {
    init {
        val name = null
    }
}
