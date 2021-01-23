package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main { // Main Class Scope begins here.
    private static Category[] categories; //instances variables are declared here.
    private static Customer customer;

    public static void main(String[] args) { // Main method scope begins here.
        addCategories();
        addCustomer();
        menu();
    } //main method scope finishes here

    private static void addCategories() { // addCategories method scope begins here.
        Food[] fastFoodList = new Food[]{   //we created fastFoodList including 3 foods and  assigned id,name and price to 3 foods.
                new Food(0, "Hamburger", 5), // Hamburger's price is 5$ and id number of it is 0
                new Food(1, "Pizza", 4),
                new Food(2, "Hotdog", 3),
        };
        Category fastFood = new Category(0, "Fast Foods", fastFoodList);
        // We created an Fast Foods category in Category Class.
        // We assigned id(0),name and FastFoodList to Fast Foods category.

        Food[] dietFoodList = new Food[]{ //We created an dietFoodList including 3 foods
                new Food(0, "Fish", 5),
                new Food(1, "Soup", 4),
                new Food(2, "Meatballs", 6),
        };
        Category dietFood = new Category(1, "Diet food", dietFoodList);
        //We created an Diet Meals category in Category Class and it's id number is 1
        //We assigned name ,id and dietFoodList to DietMeals category

        Food[] desertList = new Food[]{ //We created a desertList containg 3 desserts
                new Food(0, "Baklava", 8),
                new Food(1, "Kaddayif", 4),
                new Food(2, "Pudding", 6),
        };
        Category desserts = new Category(2, "Desserts", desertList);
        //We created an Desserts category in Category Class and it's id number is 2
        //We assigned name ,id and desertList to Desserts category

        Food[] drinkList = new Food[]{ // we created a drinkList containing 3 drinks
                new Food(0, "Cola", 1),
                new Food(1, "Water", 1),
                new Food(2, "Milk", 2),
        };
        Category drinks = new Category(3, "Drinks", drinkList);
        //We created an Drinks  category in Category Class and it's id number is 3
        //We assigned name ,id and drinkList to Drinks category


        categories = new Category[]{  //4 types of categories is collected in categories array.
                fastFood,
                dietFood,
                desserts,
                drinks
        };
    } // addCategories method scope ends here.

    private static void addCustomer() {  //addCustomer method scope begins here.
        //This system opens to only registered user
        System.out.println("Welcome to Restaurant No:7");
        System.out.println("***************************");
        Scanner scanner = new Scanner(System.in); // In this method ,user enters her/his name and surname
        System.out.println("Login screen is opening !");
        System.out.println("Please enter your Name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your Surname:");
        String surname = scanner.nextLine();
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Logged in succesfully !");
        customer = new Customer(name, surname, username);// New customer object is created with entered 2 parameters(name,surname)
            }// addCustomer method scope finishes here.

    private static boolean loop = true;

    private static void menu() {   // menu method scope begins here.
                                  // We created a menu method and put it into while(true) to create infinite loop.
        while (loop) {           // Infinite loop provides to menu be printed until it get out of the loop.
            System.out.println();
            System.out.println("The Menu is shown below ");
            System.out.println("Please enter -1 for Exit");
            System.out.println("Please enter  0 to show Categories");
            System.out.println("Please enter  1 to show All foods options");
            System.out.println("Please enter  2 for order");
            System.out.println("Please enter  3 for payment ");

            int choice = new Scanner(System.in).nextInt(); // users enter a number from menu.
            if (choice == -1) // if user press -1 ,the while(loop) is broken and program is terminated.
                return;
            //  for the whole menu options except -1,the run method is calling.
            run(choice);
        } // the while loop ends here so other ones cannot be putted into infinity loop.
    } // menu method scope ends here.

    private static void run(int choice) { // run method scope begins here
        switch (choice) {
            case 0:
                showCategories(); // if user enter 0,showCategories method is called.
                break;
            case 1:
                showAllFood(); // if user enter 1,showAlFood method is called.
                break;
            case 2:
                order(); // if user enter 2, order method is called
                break;
            case 3:
                pay(); // if user enter 3 ,pay method is called.
                break;
        }
    } // run method scope finishes here

    private static void showCategories() { // showCategories method scope begins here
        for (Category category : categories) // every category in categories is printed with ID number and name.
            System.out.println("ID Number: " + category.getId() + ",Name: " + category.getName());
    } //  showCategories method scope finishes here

    private static void showAllFood() { // showAllFood method scope begins here
        for (Category category : categories) { // Each Category in categories Array are called using getName()
            System.out.println(category.getName());
            Food[] foodList = category.getFoodList();// FoodList in every category is called using getFoodList()
            for (Food food : foodList)
                System.out.println("ID Number : " + food.getId() + ", Name: " + food.getName() + ", Price: " + food.getPrice() + "$");
            // every food in foodList in categories is called and they are printed with their id,name and price
        } //we used nested for loops.
    } //showAllFood method scope ends here

    private static void order() { // order method scope begins here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter  one Category ID Number");
        showCategories(); // We are calling the whole categories.
        int categoryId = scanner.nextInt();
        Category selectedCategory = categories[categoryId]; // we are holding selected category as selectedcategoy in Category Array.

        System.out.println("Please enter  one Food ID Number ");
        showFood(selectedCategory); // we showed that the foodList of selected category.
        int foodId = scanner.nextInt();
        Food[] foodList = selectedCategory.getFoodList(); //
        Food selectedFood = foodList[foodId]; // selected

        customer.getBasket().add(selectedFood); // We added selected food to Basket with Array List in Customer.
        customer.setPrice(customer.getPrice() + selectedFood.getPrice());
        // Final total costs are arranged by adding prices of selected foods with using getPrice method
    } // order method scope finishes here.

    private static void showFood(Category selectedCategory) { // showFood method scope begins here
        Food[] foodList = selectedCategory.getFoodList(); // We created foodList that is created from the foods in selected Category
        for (Food food : foodList) // foods in foodList is printed with their ID Number,name and price.
            System.out.println("ID Number : " + food.getId() + ",Name: " + food.getName() + ", Price: " + food.getPrice() + "$");
    }// showFood method scope finishes here

    private static void pay() { //pay method scope begins here.
        System.out.println("Your Orders :");
        ArrayList<Food> foodList = customer.getBasket();
        for (Food food : foodList) // The whole selected foods were  added to basket and it is calling now.
            System.out.println("Name: " + food.getName() + ", Price: " + food.getPrice() +"$");
        // The whole selected food are printed with their price and name
        System.out.println("Please choose one of the options below");
        System.out.println("Enter O for CONTINUE  or  any number for COMPLETE THE ORDER . ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 0) // if user enters 0,the menu will be played again.
            return; // return the 14.line
        System.out.println("Your order has been received!");
        System.out.println("Total price you must to pay is : " + customer.getPrice() + "$"); // Finally total price is printed
        // We accepted that the only payment option is credit card and
        System.out.println("Thank you fo choosing us");
        loop = false; // the system will be terminated.
    } // pay method scope finishes here.
} // Main Class Scope finishes here.
