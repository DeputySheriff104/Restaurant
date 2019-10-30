package restaurant.menu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import restaurant.dishes.Dish;
import restaurant.dishes.Drink;
import restaurant.dishes.MainCourse;
import restaurant.dishes.Salad;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class Menu {

    private Map<String, ArrayList<Dish>> dishTypesMap = new HashMap<>();

    public void readFromJson(String jsonPath) throws IOException {
        Type mainCoursesMapType = new TypeToken<ArrayList<MainCourse>>() {}.getType();
        Type saladsMapType = new TypeToken<ArrayList<Salad>>() {}.getType();
        Type drinksMapType = new TypeToken<ArrayList<Drink>>() {}.getType();
        String strJsonMenu = new String(Files.readAllBytes(Paths.get(jsonPath)));
        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(strJsonMenu);
        JsonArray jsonArrMainCourses = jo.getAsJsonArray("Main Courses");
        JsonArray jsonArrSalads = jo.getAsJsonArray("Salads");
        JsonArray jsonArrDrinks = jo.getAsJsonArray("Drinks");
        Gson googleJson = new Gson();
        dishTypesMap.put("Main Courses", googleJson.fromJson(jsonArrMainCourses, mainCoursesMapType));
        dishTypesMap.put("Salads", googleJson.fromJson(jsonArrSalads, saladsMapType));
        dishTypesMap.put("Drinks", googleJson.fromJson(jsonArrDrinks, drinksMapType));
    }

    public Map<String, ArrayList<Dish>> getDishTypesMap() {
        return dishTypesMap;
    }
}
