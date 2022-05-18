package ru.learnup.lesson22springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.lesson22springjdbc.test.Test;

@SpringBootApplication
public class Lesson22SpringJdbcApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Lesson22SpringJdbcApplication.class, args);

        context.getBean(Test.class).execute(context);

    }

}
