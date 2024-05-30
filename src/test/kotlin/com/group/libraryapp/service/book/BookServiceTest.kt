package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.book.BookType
import com.group.libraryapp.domain.user.*
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BookServiceTest @Autowired constructor(
        private val bookService: BookService,
        private val bookRepository: BookRepository,
        private val userRepository: UserRepository,
        private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {

    @Test
    @DisplayName("책 등록이 정상 동작한다.")
    fun saveBookTest() {
        //given
        val request = BookRequest("이상한 나라의 앨리스", BookType.SOCIETY)

        //when
        bookService.saveBook(request)

        //then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("이상한 나라의 앨리스")
        assertThat(books[0].type).isEqualTo(BookType.SOCIETY)
    }

    @Test
    @DisplayName("책 대여 권수를 정상 확인한다")
    fun countLoanedBookTest() {
        //given
        val savedUser = userRepository.save(User("hr", UserStatus.ACTIVE, null))
        userLoanHistoryRepository.saveAll(
                listOf(
                    UserLoanHistory.fixture(savedUser, "A"),
                    UserLoanHistory.fixture(savedUser, "B", UserLoanStatus.RETURNED),
                    UserLoanHistory.fixture(savedUser, "C", UserLoanStatus.RETURNED),
                )
        )

        //when
        val result = bookService.countLoanedBook()

        //then
        assertThat(result).isEqualTo(1)
    }

    @Test
    @DisplayName("분야별 책 권수를 정상 확인한다.")
    fun getBookStatisticsTest() {
        //given
        bookRepository.saveAll(listOf(
            Book.fixture("A", BookType.SOCIETY),
            Book.fixture("B", BookType.ECONOMY),
            Book.fixture("C", BookType.LANGUAGE)
        ))

        //when
        val result = bookService.getBookStatistics()

        //then
        assertThat(result).hasSize(3)
        assertCount(result, BookType.ECONOMY, 1)
        assertCount(result, BookType.SOCIETY, 1)

    }

    private fun assertCount(result: List<BookStatResponse>, type: BookType, expectedCount: Long) {
        assertThat(result.first { it.type == type }.count).isEqualTo(expectedCount)
    }


}