package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.UserLoanHistory
import com.group.libraryapp.domain.user.UserLoanStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long>