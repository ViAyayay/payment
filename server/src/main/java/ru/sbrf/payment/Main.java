package ru.sbrf.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(
//                "ru.sbrf.example.user", "ru.sbrf.example.putting_taking");

        User user = getBean

    }
}
