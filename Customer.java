package com.company;
import java.util.ArrayList;

public class Customer {
    private String customername; // initial variables (name,surname and price) are declared in private type
    private String customersurname;
    private String customerusername;
    private int price = 0; // the price is initialized as 0 to calculate correct price at the end.
    private final  ArrayList<Food> basket = new ArrayList<>();
// we created an Arraylist which is called basket to collect the whole selected from from foods

    public Customer(String name, String surname,String username) { // Name and surname are assigned to every Customer
        this.customername = name;
        this.customersurname = surname;
        this.customerusername=username;
    }

    public String getName() {   // Customer name  is taken and returned using getName method

        return customername;
    }

    public void setName(String name) {   // The name of every customers is changed using setName method
        this.customername = name;                // name is a parameter(argument) in String type
    }

    public String getSurname() {         // The Customer surname is taken and returned using  getSurname method.

        return customersurname;
    }

    public void setSurname(String surname) { // The Customer Surname is changed using setSurname method.
        this.customersurname = surname;              // surname is a parameter in String type.
    }
    public  String getUsername(){
        return customerusername;
    }
    public void setUsername(String username){
        this.customerusername=username;
    }

    public int getPrice() {                  // Total price of basket is printed using getPrice method.

        return price;
    }

    public void setPrice(int price) {         // Total price of basket is changed using setPrice method.
        this.price = price;
    }

    public ArrayList<Food> getBasket() {       // the  selected whole foods are collected in basket and taken using getBasket method.
        return basket;
    }
}
