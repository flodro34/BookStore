package com.fdr.bookstore.services;

import com.fdr.bookstore.dto.BookDTO;
import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;

import java.util.List;

public interface BookService {

    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO);

    BookDTO getBookById(Long id);
    List<BookDTO> getAllBooks();

    void deleteBookById(Long id);
    void deleteBook(Book book);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByCategory(Category category);
    List<Book> getBooksByCategoryId(Long id);
    List<Book> sortBooksTitlePrice();

    BookDTO convertEntityToDto(Book b);
    Book convertDtoToEntity(BookDTO dto);
}
