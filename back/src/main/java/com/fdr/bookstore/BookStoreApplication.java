package com.fdr.bookstore;

import com.fdr.bookstore.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration restConfig;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfig.exposeIdsFor(Book.class);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
