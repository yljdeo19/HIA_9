package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DiscountRate discountRate = context.getBean("discountRate", DiscountRate.class);
        System.out.println(discountRate);

        System.out.println("Select Product: \n" +
                "1. Product №1 \n" +
                "2. Product №2 \n" +
                "3. Product №3");
        int choice = sc.nextInt();
//        if(choice == 1){
//            customer.getProducts().add("Product_№1");
//        }
//        else if (choice == 2){
//            customer.getProducts().add("Product_№2");
//        }
//        else if (choice == 3){
//            customer.getProducts().add("Product_№3");
//        }
//        else
//            System.out.println("Error");

        System.out.println("Select Services: \n" +
                "1. Service №1 \n" +
                "2. Service №2 \n" +
                "3. Service №3");


        choice = sc.nextInt();
//        if(choice == 1){
//            customer.getServices().add("Service_№1");
//        }
//        else if (choice == 2){
//            customer.getServices().add("Service_№2");
//        }
//        else if (choice == 3){
//            customer.getServices().add("Service_№3");
//        }
//        else
//            System.out.println("Error");

        discountRate.payment();
        context.close();
    }
}
