package restaurant.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import restaurant.dishes.Dish;
import restaurant.dishes.Drink;
import restaurant.dishes.MainCourse;
import restaurant.dishes.Salad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private Map<String, ArrayList<Dish>> dishTypesMap = new HashMap<>();



    public Menu() {
        dishTypesMap.put("Main Courses", new ArrayList<>());
        dishTypesMap.get("Main Courses").add(new MainCourse("Lasagna", 20, 15, 200));
        dishTypesMap.put("Salads", new ArrayList<>());
        dishTypesMap.get("Salads").add(new Salad("Caesar", 15, 10, 150));
        dishTypesMap.put("Drinks", new ArrayList<>());
        dishTypesMap.get("Drinks").add(new Drink("Beer", 10, 5, 100));

    }

    public void readFromJson(String json) {
        MainCourse mainCourse = GSON.fromJson(json, MainCourse.class);
    }

    public HashMap<String, ArrayList<Dish>> getDishTypesMap() {
        return (HashMap<String, ArrayList<Dish>>) dishTypesMap;
    }
}
