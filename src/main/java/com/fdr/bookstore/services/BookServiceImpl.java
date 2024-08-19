package com.fdr.bookstore.services;

import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;
import com.fdr.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
       return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getBooksByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }

    @Override
    public List<Book> getBooksByCategoryId(Long id) {
        return bookRepository.findByCategoryIdCat(id);
    }

    @Override
    public List<Book> sortBooksTitlePrice() {
        return bookRepository.sortBookTitlePrice();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }


}
