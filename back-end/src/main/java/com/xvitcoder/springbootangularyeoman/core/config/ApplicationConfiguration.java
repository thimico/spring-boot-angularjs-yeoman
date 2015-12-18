package com.xvitcoder.springbootangularyeoman.core.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by xvitcoder on 12/18/15.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xvitcoder.springbootangularyeoman.core")
@EntityScan(basePackages = "com.xvitcoder.springbootangularyeoman.core.domain")
@EnableJpaRepositories(basePackages = "com.xvitcoder.springbootangularyeoman.core.repository")
public class ApplicationConfiguration {
}
