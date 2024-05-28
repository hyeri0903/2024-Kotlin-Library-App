package com.group.libraryapp.domain.user

import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookName: String,

    var isReturn: Boolean = false,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

) {

    fun doReturn() {
        this.isReturn = true
    }
}