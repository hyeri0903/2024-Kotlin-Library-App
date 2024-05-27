package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.libraryapp.domain.user.UserLoanHistory;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

  JavaUserLoanHistory findByBookNameAndIsReturn(String bookName, boolean isReturn);

}
