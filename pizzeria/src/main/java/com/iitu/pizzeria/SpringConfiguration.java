package com.iitu.pizzeria;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
@ComponentScan("com.iitu.pizzeria")
@PropertySource("application.properties")
public class SpringConfiguration {

}
