package com.example.config;


import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@PropertySource("classpath:application.properties")
@Configuration
@Import(value = {
        PlayerConfig.class
        , DataJpaConfig.class
        , MyBatisConfig.class
})
@ComponentScan(basePackages = "com.example.service")
public class ApplicationConfig {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Autowired
    private Environment env;

    @PostConstruct
    public void setActiveProfiles() {
        configurableEnvironment.setActiveProfiles(env.getProperty("spring.profiles.active"));
    }

    @Bean
    public InjectRandomLevelAnnotationBeanPostProcessor injectRandomLevel() {
        return new InjectRandomLevelAnnotationBeanPostProcessor();
    }
}
