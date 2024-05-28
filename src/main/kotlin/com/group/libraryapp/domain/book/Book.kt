package com.group.libraryapp.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book constructor(
    val name: String,

    val type: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    companion object {
        fun fixture(
                name: String = "책 이름",
                type: String = "computer",
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