package com.spring.SpringCoreDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.payment.PaymentProject.PaymentService;
import com.spring.SpringCoreDemo.db.EmployeeDB;
import com.spring.SpringCoreDemo.payment.Email;
import com.spring.SpringCoreDemo.payment.Invoice;
import com.spring.SpringCoreDemo.payment.Notification;
import com.spring.SpringCoreDemo.payment.SMS;
import com.spring.SpringCoreDemo.payment.WhatsApp;

/**
 * Hello world!
 *
 */
//@Configuration
@ComponentScan(basePackages = {"test","com.spring.SpringCoreDemo"})
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	System.out.println("context loaded");
    	Email emailob = new Email();  
//    	emailob.display();
        Invoice invoice =context.getBean(Invoice.class);// = spring give me + inject Notification
       invoice.processOrder();
       for(String name : context.getBeanDefinitionNames())
    	   System.out.println(name);
       System.out.println();
       
       EmployeeDB db = context.getBean(EmployeeDB.class);
       System.out.println(db.getEmpCount());
       System.out.println(db.getEmployeeByEid(1));
    }
    @Bean("email")
    @Primary
    public Email emailInstance() {
    	System.out.println("Email instance created");
    	return new Email();
    }
    @Bean
    public PaymentService service()
    {
    	return new PaymentService();
    }
}
