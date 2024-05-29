package com.group.libraryapp.dto.book

import com.group.libraryapp.domain.book.BookType

data class BookRequest(
    val name: String,
    val type: BookType,
) {
    init {
        val name = null
    }
}
