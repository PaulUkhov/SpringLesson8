package org.example.soringlesson8homework.repository.task1;


import org.example.soringlesson8homework.model.task1.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
