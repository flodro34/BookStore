package com.fdr.bookstore.controllers;

import com.fdr.bookstore.dto.BookDTO;
import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public BookDTO getBookById(@PathVariable("id") Long id){
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public BookDTO addBook(@RequestBody BookDTO bookDTO){

        return bookService.saveBook(bookDTO);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public BookDTO updateBook(@RequestBody BookDTO bookDTO){

        return bookService.updateBook(bookDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteBook(@RequestBody Book book){
        bookService.deleteBook(book);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
    }

    @RequestMapping(value = "/bookscat/{idCat}", method = RequestMethod.GET)
    public List<Book> getBooksByCategory(@PathVariable("idCat") Long idCat){
        return bookService.getBooksByCategoryId(idCat);
    }
}
