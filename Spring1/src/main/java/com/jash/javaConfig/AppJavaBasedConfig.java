package com.jash.javaConfig;

import com.jash.Alien;
import com.jash.javaConfig.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppJavaBasedConfig
{
    public static void main( String[] args )
    {
        System.out.println( "Java Based Config" );
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Alien alien = (Alien) applicationContext.getBean("bhoot",Alien.class);
        System.out.println(alien.getAge());
    }

    /*
    Manual creation of bean
    Alien alien = new Alien();
    alien.code();
    */
}
