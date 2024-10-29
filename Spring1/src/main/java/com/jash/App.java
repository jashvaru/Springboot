package com.jash;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien = (Alien) applicationContext.getBean("alien");
        System.out.println(alien.getAge());
    }

    /*
    Manual creation of bean
    Alien alien = new Alien();
    alien.code();
    */
}
