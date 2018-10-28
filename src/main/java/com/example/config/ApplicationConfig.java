package com.example.config;


import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor;
import com.example.domain.Player;
import com.example.domain.PlayerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PlayerConfig.class})
public class ApplicationConfig {

    @Bean
    InjectRandomLevelAnnotationBeanPostProcessor injectRandomLevel() {
        return new InjectRandomLevelAnnotationBeanPostProcessor();
    }
}
