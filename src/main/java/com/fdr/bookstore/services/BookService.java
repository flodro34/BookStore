package com.fdr.bookstore.services;

import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
    void deleteBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByCategory(Category category);
    List<Book> getBooksByCategoryId(Long id);
    List<Book> sortBooksTitlePrice();

}
