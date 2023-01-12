package com.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author prabh
 * @implNote This is the Spring boot main class.
 */
@SpringBootApplication
@Slf4j
public class PalindromeApplication {

    public static void main(String[] args) {
        log.info("Starting the application");
        SpringApplication.run(PalindromeApplication.class, args);
    }
}
