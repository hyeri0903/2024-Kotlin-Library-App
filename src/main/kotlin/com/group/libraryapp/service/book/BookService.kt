package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.BookLoanRequest
import com.group.libraryapp.dto.book.BookRequest
import com.group.libraryapp.dto.book.BookReturnRequest
import com.group.libraryapp.dto.user.UserResponse
import com.group.libraryapp.util.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @Transactional
    fun saveBook(request: BookRequest) {
        bookRepository.save(request.name ?: "")
    }

    @Transactional
    fun loanBook(request: BookLoanRequest) {
        if (userLoanHistoryRepository.findByBookNameAndIsReturn(request.bookName, false) != null) {
            throw IllegalArgumentException(" ") }
        val book = bookRepository.findByName(request.bookName) ?: fail()
        val user = userRepository.findByName(request.userName) ?: fail()
        user.loanBook(book)
    }

    @Transactional
    fun returnBook(request: BookReturnRequest) {
        val user = request.userName?.let { userRepository.findByName(it) } ?: fail()
        user.returnBook(UserResponse::of.toString())
    }
}