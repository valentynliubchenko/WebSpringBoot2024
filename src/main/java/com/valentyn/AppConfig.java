package com.valentyn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
//    @Bean(name="SecondPerson")
	@Scope("prototype")
    public Person myPerson(){
        return new Person();
    }
}
