package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import javax.persistence.*

@Entity
class User(
    var name: String,

    @Enumerated(EnumType.STRING)
    val status: UserStatus,

    val age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {


    fun updateName(name: String) {
        this.name = name
    }


    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name))
    }

    fun returnBook(bookName: String) {
        this.userLoanHistories.first { history -> history.bookName == bookName }.doReturn()
    }

}