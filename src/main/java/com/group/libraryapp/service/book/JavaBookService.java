// package com.group.libraryapp.service.book;
//
// import com.group.libraryapp.domain.book.JavaBook;
// import com.group.libraryapp.domain.book.JavaBookRepository;
// import com.group.libraryapp.domain.user.JavaUser;
// import com.group.libraryapp.domain.user.JavaUserRepository;
// import com.group.libraryapp.domain.user.loanhistory.JavaUserLoanHistoryRepository;
// import com.group.libraryapp.dto.book.request.BookLoanRequest;
// import com.group.libraryapp.dto.book.request.BookRequest;
// import com.group.libraryapp.dto.book.request.BookReturnRequest;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// @Service
// public class JavaBookService {
//
//   private final JavaBookRepository javaBookRepository;
//   private final JavaUserRepository javaUserRepository;
//   private final JavaUserLoanHistoryRepository javaUserLoanHistoryRepository;
//
//   public JavaBookService(
//       JavaBookRepository javaBookRepository,
//       JavaUserRepository javaUserRepository,
//       JavaUserLoanHistoryRepository javaUserLoanHistoryRepository
//   ) {
//     this.javaBookRepository = javaBookRepository;
//     this.javaUserRepository = javaUserRepository;
//     this.javaUserLoanHistoryRepository = javaUserLoanHistoryRepository;
//   }
//
//   @Transactional
//   public void saveBook(BookRequest request) {
//     JavaBook newBook = new JavaBook(request.name);
//     javaBookRepository.save(newBook);
//   }
//
//   @Transactional
//   public void loanBook(BookLoanRequest request) {
//     JavaBook book = javaBookRepository.findByName(request.bookName).orElseThrow(IllegalArgumentException::new);
//     if (javaUserLoanHistoryRepository.findByBookNameAndIsReturn(request.bookName, false) != null) {
//       throw new IllegalArgumentException("진작 대출되어 있는 책입니다");
//     }
//
//     JavaUser user = javaUserRepository.findByName(request.userName).orElseThrow(IllegalArgumentException::new);
//     user.loanBook(book);
//   }
//
//   @Transactional
//   public void returnBook(BookReturnRequest request) {
//     JavaUser user = javaUserRepository.findByName(request.userName).orElseThrow(IllegalArgumentException::new);
//     user.returnBook(request.bookName);
//   }
//
// }
