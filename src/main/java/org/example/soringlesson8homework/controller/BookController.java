package org.example.soringlesson8homework.controller;

import lombok.RequiredArgsConstructor;
import org.example.soringlesson8homework.model.task1.Book;
import org.example.soringlesson8homework.service.task1.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.ok(book);
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            return ResponseEntity.ok(bookService.update(id,book));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/book")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            bookService.delete(id);
        }
        return ResponseEntity.ok().build();
    }
}
