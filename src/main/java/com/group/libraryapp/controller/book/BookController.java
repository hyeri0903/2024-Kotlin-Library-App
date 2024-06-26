// package com.group.libraryapp.controller.book;
//
// import com.group.libraryapp.dto.book.request.BookLoanRequest;
// import com.group.libraryapp.dto.book.request.BookRequest;
// import com.group.libraryapp.dto.book.request.BookReturnRequest;
// import com.group.libraryapp.service.book.JavaBookService;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class BookController {
//
//   private final JavaBookService javaBookService;
//
//   public BookController(JavaBookService javaBookService) {
//     this.javaBookService = javaBookService;
//   }
//
//   @PostMapping("/book")
//   public void saveBook(@RequestBody BookRequest request) {
//     javaBookService.saveBook(request);
//   }
//
//   @PostMapping("/book/loan")
//   public void loanBook(@RequestBody BookLoanRequest request) {
//     javaBookService.loanBook(request);
//   }
//
//   @PutMapping("/book/return")
//   public void returnBook(@RequestBody BookReturnRequest request) {
//     javaBookService.returnBook(request);
//   }
//
// }
