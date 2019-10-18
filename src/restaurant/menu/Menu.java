package restaurant.menu;

import restaurant.dishes.Dish;
import restaurant.dishes.Drink;
import restaurant.dishes.MainCourse;
import restaurant.dishes.Salad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Menu {

    private HashMap<String, ArrayList<Dish>> dishTypesMap = new HashMap<>();

    public Menu() {
        dishTypesMap.put("Main Courses", new ArrayList<>());
        dishTypesMap.get("Main Courses").add(new MainCourse("Lasagna", 20, 15, 200));
        dishTypesMap.put("Salads", new ArrayList<>());
        dishTypesMap.get("Salads").add(new Salad("Caesar", 15, 10, 150));
        dishTypesMap.put("Drinks", new ArrayList<>());
        dishTypesMap.get("Drinks").add(new Drink("Beer", 10, 5, 100));

    }

    /*public void readMenuFromTextFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        String dishType;

        String name = "Nothing";
        int price = 0, cookingTime = 0, calories = 0;

        while (sc.hasNextLine()) {
            sc.useDelimiter(",");
            String currentLine = sc.nextLine();
            if (currentLine == "Main Courses" || currentLine == "Salads" || currentLine == "Drinks") {
                dishType = currentLine;
            }
            else {
                name = sc.next();
                *//*sc.useDelimiter("\\D"); //ВСЕ ЦИФРЫ
                price = sc.nextInt();
                 cookingTime = sc.nextInt();
                calories = sc.nextInt();*//*
            }
            System.out.println(name); //+ " " + price + " " + cookingTime + " " + calories);
        }
    }*/

    public HashMap<String, ArrayList<Dish>> getDishTypesMap() {
        return dishTypesMap;
    }
}
