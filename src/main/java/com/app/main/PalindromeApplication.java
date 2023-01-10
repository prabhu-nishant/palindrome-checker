package com.app.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.app"})
@EnableJpaRepositories(basePackages = {"com.app"})
@EnableCaching
@ComponentScan(basePackages = {"com.app"})
@Slf4j
public class PalindromeApplication {

    public static void main(String[] args) {
        log.info("Starting the application");
        SpringApplication.run(PalindromeApplication.class, args);
    }
}
