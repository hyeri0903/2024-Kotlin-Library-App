package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.UserLoanHistory
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {
    fun findByBookNameAndIsReturn(bookName: String, isReturn: Boolean): Optional<UserLoanHistory>
}