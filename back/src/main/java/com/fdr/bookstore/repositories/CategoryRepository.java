package com.fdr.bookstore.repositories;

import com.fdr.bookstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
