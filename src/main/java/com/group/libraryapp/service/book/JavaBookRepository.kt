//package com.group.libraryapp.service.book
//
//import com.group.libraryapp.domain.book.JavaBook
//import org.springframework.data.jpa.repository.JpaRepository
//import java.util.Optional
//
//interface JavaBookRepository : JpaRepository<JavaBook, Long> {
//
//    fun findByName(bookName: String): Optional<JavaBook>
//}