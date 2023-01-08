package com.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.app.entity"})
@EnableJpaRepositories(basePackages = "com.app.repository")
@EnableCaching
@ComponentScan(basePackages = "com.app")
public class PalindromeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalindromeApplication.class, args);
    }
}
