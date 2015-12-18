package com.xvitcoder.springbootangularyeoman.web.config;

import com.xvitcoder.springbootangularyeoman.core.config.ApplicationConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by xvitcoder on 12/18/15.
 */
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages = "com.xvitcoder.springbootangularyeoman.web")
@Import({ApplicationConfiguration.class})
public class WebApplicationConfiguration {

}
