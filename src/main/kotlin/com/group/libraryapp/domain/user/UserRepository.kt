package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<JavaUser, Long> {
    fun findByName(userName: String): Optional<JavaUser>
}