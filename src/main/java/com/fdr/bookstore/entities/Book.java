package com.fdr.bookstore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String title;
    private String author;
    private Double price;

    @ManyToOne
    private Category category;

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
