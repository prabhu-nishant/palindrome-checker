package com.app;

import com.app.repository.PalindromeDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author prabh
 * @implNote This is the Spring boot main class.
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.app"})
@EnableJpaRepositories(basePackages = {"com.app"})
@ComponentScan(basePackages = {"com.app"})
@EnableCaching
@Slf4j
public class PalindromeApplication {

    public static void main(String[] args) {
        log.info("Starting the application");
        SpringApplication.run(PalindromeApplication.class, args);
    }
}
