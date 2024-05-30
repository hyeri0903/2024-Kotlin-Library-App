package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.UserLoanHistory
import com.group.libraryapp.domain.user.UserLoanStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {
    fun findByBookNameAndStatus(bookName: String, status: UserLoanStatus): UserLoanHistory?

    fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory>

    fun countByStatus(status: UserLoanStatus): Long
}