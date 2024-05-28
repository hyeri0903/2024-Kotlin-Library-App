package com.group.libraryapp.dto.user

data class UserCreateRequest(
    val name: String,
    val age: Int?
) {
}