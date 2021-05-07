package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscountRate {

    private Gold gold;

    @Autowired
    public DiscountRate(Gold gold) {
        this.gold = gold;
    }

    public void payment() {

        double totalCena = 0;

        for (String i : gold.getProducts()) {
            if (i.equalsIgnoreCase("Product_№1")) {
                totalCena += 2000;
            }
            else if (i.equalsIgnoreCase("Product_№2")) {
                totalCena += 2500;
            }
            else if (i.equalsIgnoreCase("Product_№3")) {
                totalCena += 3000;
            }
        }

        for (String i : gold.getServices()) {
            if (i.equalsIgnoreCase("Service_№1")) {
                totalCena += 2000;
            }
            else if (i.equalsIgnoreCase("Service_№2")) {
                totalCena += 2500;
            }
            else if (i.equalsIgnoreCase("Service_№3")) {
                totalCena += 3000;
            }
        }

        totalCena = totalCena *(100 - gold.getDIS())/100;

        if (totalCena > gold.getSchet()) {
            System.out.println("Insuficient money on account.");
        }
        else {
            System.out.println("You paid: " + totalCena + " $ \n" +
                    "Your Balance: " + gold.platy(totalCena));
        }
    }
    public String toString() {
        return "Customer{" +
                "name='" + gold + '\'' +
                '}';
    }
}
