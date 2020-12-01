package com.mumuni.toy.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 사용
       SpringApplication.run(Application.class, args);
    }
}
