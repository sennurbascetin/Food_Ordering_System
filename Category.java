package com.company;
public class Category {
    private int categoryid; // initial varibles(id,name,foodlist) are declared in private type .
    private String categoryname;
    private Food[] foodList; // In each category,there is an foodlist that contains 3 foods option

    public Category(int id, String name, Food[] foodList) {
        this.categoryid = id;      // id ,name and foodList are assigned to every categories.
        this.categoryname = name;
        this.foodList = foodList;
    }

    public int getId() { // The ID of categories is taken  and  returned using getId method
        return categoryid;
    }

    public void setId(int id) {  // The given ID of categories  is changed using setId method
        this.categoryid = id;            // id is parameter in integer type
    }

    public String getName() {    // Name of every categories is taken and is returned using getName method
        return categoryname;
    }

    public void setName(String name) { // The name of every categories is changed using setName method
        this.categoryname = name;              // name is a parameter(argument) in String type
    }

    public Food[] getFoodList() { // The foods in food lists of every categories is taken using getFoodList method.
        return foodList;
    }

    public void setFoodList(Food[] foodList) {  // The foods in food lists of every categories is changed using setFoodList method.
        this.foodList = foodList;
    }
}
