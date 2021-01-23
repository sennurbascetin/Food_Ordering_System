package com.company;
public class Food {
    private int foodid; // initial varibles are  declared in private type .
    private String foodname;
    private int foodprice; // Every foods have price,name and id properties.

    public Food(int id, String name, int price) { // name ,id and price are assigned to food.
        this.foodid = id;
        this.foodname = name;
        this.foodprice = price;
    }

    public int getId() { // The ID of food is taken  and  returned using getId method
        return foodid;
    }

    public void setId(int id) { // The given ID of food  is changed using setId method
        this.foodid = id;           // id is parameter in integer type
    }

    public String getName() {  // Food name  is taken and returned using getName method
        return foodname;
    }

    public void setName(String name) { // The name of every food is changed using setName method
        this.foodname = name;              // name is a parameter(argument) in String type
    }

    public int getPrice() {  // The price of food is taken and returned using getPrice method.
        return foodprice;
    }

    public void setPrice(int price) { // The price of food is changed using setPrice method.
        this.foodprice = price;           // the price is a parameter in int type
    }
}
