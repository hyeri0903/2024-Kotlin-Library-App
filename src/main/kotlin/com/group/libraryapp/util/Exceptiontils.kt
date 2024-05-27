package com.group.libraryapp.util

class Exceptiontils {

    companion object {
        fun fail(): Nothing {
            throw IllegalArgumentException()
        }
    }
}