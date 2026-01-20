package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main application class for the Spring Boot demo.
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    /**
     * Main entry point of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Root endpoint returning a greeting message.
     *
     * @return greeting string
     */
    @GetMapping("/")
    public final String hello() {
        return "Hello from Secure CI/CD Pipeline!";
    }

}
