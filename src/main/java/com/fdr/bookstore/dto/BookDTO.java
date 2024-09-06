package com.fdr.bookstore.dto;

import com.fdr.bookstore.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Long idBook;
    private String title;
    private String author;
    private Double price;
    private Category category;
    //private String categoryName;

}
