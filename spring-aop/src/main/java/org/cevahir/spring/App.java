package org.cevahir.spring;

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
        ApplicationContext applicationContext = 
        	new ClassPathXmlApplicationContext("/orkestra.xml");
        
        MaystroServisi maystroServisi = 
        	(MaystroServisi) applicationContext.getBean("maystro");
        
        maystroServisi.yonet();
    }
}
