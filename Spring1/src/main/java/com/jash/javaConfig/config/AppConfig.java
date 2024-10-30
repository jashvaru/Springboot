package com.jash.javaConfig.config;

import com.jash.Alien;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


     //Specify multiple names for the bean
//    @Bean(name = "alien1")   //Specify name for the bean
//    @Bean                //by default method name is bean name
    @Bean(name = {"alien1", "bhoot"})
    public Alien alien(){
        return new Alien();
    }
}
