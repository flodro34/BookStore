package com.fdr.bookstore.repositories;

import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthor(String author);

    @Query("select b from Book b where b.category = ?1")
    List<Book> findByCategory(Category category);

    List<Book> findByCategoryIdCat(Long id);

    List<Book> findByOrderByTitleAsc();

    @Query("select b from Book b order by b.title DESC, b.price DESC")
    List<Book> sortBookTitlePrice();

}
