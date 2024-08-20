package com.fdr.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idCat;

    private String catName;

    private String catDesc;

    @OneToMany (mappedBy = "category")
    @JsonIgnore
    private List<Book> books;

    public Category(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;
    }
}
