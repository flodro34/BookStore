package com.fdr.bookstore.services;

import com.fdr.bookstore.dto.BookDTO;
import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;
import com.fdr.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public
class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {

        return convertEntityToDto(bookRepository.save(convertDtoToEntity(bookDTO)));
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {

        return convertEntityToDto(bookRepository.save(convertDtoToEntity(bookDTO)));
    }

    @Override
    public BookDTO getBookById(Long id) {

        return convertEntityToDto(bookRepository.findById(id).get());
    }

    @Override
    public List<BookDTO> getAllBooks() {
        //programmation fonctionnelle
        return bookRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

        // Méthode "classique"
//        List<Book> books = bookRepository.findAll();
//        List<BookDTO> listBookDto = new ArrayList<>(books.size());
//        for (Book b : books)
//            listBookDto.add(convertEntityToDto(b));
//        return listBookDto;
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

    @Override
    public BookDTO convertEntityToDto(Book b ){
//        BookDTO bookDTO = new BookDTO();
//
//        bookDTO.setIdBook(b.getIdBook());
//        bookDTO.setTitle(b.getTitle());
//        bookDTO.setAuthor(b.getAuthor());
//        bookDTO.setPrice(b.getPrice());
//        bookDTO.setCategory(b.getCategory());
//
//        return bookDTO;

        // avec le builder de Lombok
        return BookDTO.builder()
                .idBook(b.getIdBook())
                .title(b.getTitle())
                .author(b.getAuthor())
                .price(b.getPrice())
                .category(b.getCategory())
                //.categoryName(b.getCategory().getCatName())
                .build();
    }

    @Override
    public Book convertDtoToEntity(BookDTO dto) {
        Book book = new Book();
        book.setIdBook(dto.getIdBook());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setCategory(dto.getCategory());
        return book;
    }
}
