package ru.learnup.lesson23_spring_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BookStoreApplication.class, args);


    }

}
