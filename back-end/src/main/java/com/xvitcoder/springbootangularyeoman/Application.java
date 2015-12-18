package com.xvitcoder.springbootangularyeoman;

import com.xvitcoder.springbootangularyeoman.web.config.WebApplicationConfiguration;
import org.springframework.boot.SpringApplication;

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationConfiguration.class, args);
    }
}
