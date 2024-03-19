package com.valentyn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
//    @Bean(name="SecondPerson")
//	@Scope("prototype")
    @Profile("default")
    public Person myPerson(){
        return new Person();
    }

    @Bean
//    @Bean(name="SecondPerson")
    @Profile("test1,test2")
    public Person myNewPerson(){
        return new Person();
    }


}
