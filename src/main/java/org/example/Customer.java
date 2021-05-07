package org.example;

import java.util.ArrayList;

public interface Customer {
    double platy(double cena);
    int getDIS();
    ArrayList<String> getProducts();
    ArrayList<String> getServices();
    double getSchet();
}
