package com.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author prabh
 * @apiNote A custom configuration class
 */
@Configuration
@EntityScan("com.app.model")
@EnableJpaRepositories("com.app.repository")
@EnableCaching
public class AppConfiguration {
}
