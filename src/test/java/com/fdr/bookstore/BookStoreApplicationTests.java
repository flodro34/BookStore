package com.fdr.bookstore;

import com.fdr.bookstore.entities.Book;
import com.fdr.bookstore.entities.Category;
import com.fdr.bookstore.repositories.BookRepository;

import com.fdr.bookstore.repositories.CategoryRepository;
import jakarta.persistence.SqlResultSetMapping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookStoreApplicationTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;



    @Test
    public void testCreateBook(){
        Book book = new Book("L'histoire de France'", "Tolkien", 25.0);
        bookRepository.save(book);
    }

    @Test
    public void testCreateCat(){
        Category category = new Category("SF","fantasy");
        categoryRepository.save(category);

    }

    @Test
    public void testGetBook(){
        Book book = bookRepository.findById(1L).get();
        System.out.println(book);
    }

    @Test
    public void testGetAllBooks(){
        List<Book> books = bookRepository.findAll();
        for(Book book : books){
            System.out.println(book);
        }
    }

    //
    @Test
    public void testUpdateBook(){

        Book b = bookRepository.findById(1L).get();
        b.setPrice(30.0);
        bookRepository.save(b);

    }

    @Test
    public void testUpdateCat(){
        Category c = categoryRepository.findById(1L).get();
        c.setCatName("Littérature");
        categoryRepository.save(c);
    }

    @Test
    public void testDeleteBook(){
        //Book b = bookRepository.findById(1L).get();
        bookRepository.deleteById(1L);
    }

    @Test
    public void testGetBookByTitle(){
        List<Book> books = bookRepository.findByTitle("Le Hobbit");

        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void testGetBookByTitleContaining(){
        List<Book> books = bookRepository.findByTitleContaining("Le ");

        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void testGetBookByAuthor(){
        List<Book> books = bookRepository.findByAuthor("Tolkien");

        for(Book book : books){
            System.out.println(book);
        }
    }

    //find book by category
    @Test
    public void testFindByCategory(){
        Category category = new Category();
        category.setIdCat(1L);

        List<Book> books = bookRepository.findByCategory(category);
        for(Book book : books){
            System.out.println(book);
        }

    }

    @Test
    public void testFindByCategoryIdCat(){
        List<Book> books = bookRepository.findByCategoryIdCat(1L);
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void testFindByOrderByTitleAsc(){
        List<Book> books = bookRepository.findByOrderByTitleAsc();
        for(Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void testSortBookTitlePrice(){
        List<Book> books = bookRepository.sortBookTitlePrice();
        for(Book book : books){
            System.out.println(book);
        }
    }


}
