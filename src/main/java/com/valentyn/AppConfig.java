package com.valentyn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
//	@Scope("prototype")
    public Person myPperson(){
        return new Person();
    }
}
