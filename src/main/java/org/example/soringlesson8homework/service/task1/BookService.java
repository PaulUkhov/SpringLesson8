package org.example.soringlesson8homework.service.task1;

import lombok.RequiredArgsConstructor;
import org.example.soringlesson8homework.aspect.task1.TrackUserAction;
import org.example.soringlesson8homework.model.task1.Book;
import org.example.soringlesson8homework.repository.task1.BookRepository;
import org.slf4j.event.Level;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@TrackUserAction(level = Level.INFO)
@Service
@RequiredArgsConstructor
public class BookService {
    BookRepository bookRepository;


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void save(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        bookRepository.save(book);
    }

    public Book update(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setAuthor(bookDetails.getAuthor());
        book.setTitle(bookDetails.getTitle());
        return bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
