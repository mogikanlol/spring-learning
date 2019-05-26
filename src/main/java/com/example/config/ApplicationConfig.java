package com.example.config;


import com.example.domain.InjectRandomLevelAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

//https://stackoverflow.com/questions/26676782/when-use-abstractannotationconfigdispatcherservletinitializer-and-webapplication
@PropertySource("classpath:application.properties")
@Configuration
@Import(value = {
        PlayerConfig.class,
        DataJpaConfig.class,
        MyBatisConfig.class
})
@ComponentScan(basePackages = "com.example.service")
public class ApplicationConfig {

    @Autowired
    private ConfigurableEnvironment configurableEnvironment;

    @Autowired
    private Environment env;

    @PostConstruct
    public void setActiveProfiles() {
        String activeProfile = env.getProperty("spring.profiles.active");

        if (activeProfile == null) {
            activeProfile = "jpa";
        }

        configurableEnvironment.setActiveProfiles(activeProfile);
    }

    @Bean
    public InjectRandomLevelAnnotationBeanPostProcessor injectRandomLevel() {
        return new InjectRandomLevelAnnotationBeanPostProcessor();
    }
}
