package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book constructor(
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    companion object {
        fun fixture(
                name: String = "책 이름",
                type: BookType = BookType.COMPUTER,
                id: Long? = null
        ): Book {
            return Book(
                    name = name,
                    type = type,
                    id = id,
            )
        }
    }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("name is not empty")
        }
    }

}