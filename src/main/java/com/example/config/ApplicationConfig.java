package com.example.config;


import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor;
import com.example.domain.Player;
import com.example.domain.PlayerFactory;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PlayerConfig.class, DatabaseConfig.class})
@ComponentScan(basePackages = "com.example.service")
public class ApplicationConfig {

    @Bean
    InjectRandomLevelAnnotationBeanPostProcessor injectRandomLevel() {
        return new InjectRandomLevelAnnotationBeanPostProcessor();
    }
}
