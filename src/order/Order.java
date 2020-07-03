package order;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import restaurant.dishes.Dish;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Dish> dishes = new ArrayList<>();
    int number;
    boolean isServed;
    int initialTime;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setInitialTime(int initialTime) {
        this.initialTime = initialTime;
    }

    public int getInitialTime() {
        return initialTime;
    }

    public void setServeStatus(boolean served) {
        isServed = served;
    }

    public int getDishesAmount() {
        return dishes.size();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public String convertToString() {
        StringBuilder str = new StringBuilder();
        if (getDishesAmount() != 0) {
            str.append("Order number ");
            str.append(number);
            str.append(" (initial time - ");
            str.append(getInitialTime());
            str.append(", cooking time - ");
            str.append(getCookingTime());
            str.append("):");
            for (Dish dish : dishes) {
                str.append("\n - ");
                str.append(dish.getName());
                str.append(" (price: ");
                str.append(dish.getPrice());
                str.append("; cookingTime: ");
                str.append(dish.getCookingTime());
                str.append("; calories: ");
                str.append(dish.getCalories());
                str.append(")");
            }
        }
        else {
            str.append("Customer has not chosen anything");
        }
        return str.toString();
    }

    public String getStringOrderIsServedMessage() {
        if (isServed) {
            StringBuilder str = new StringBuilder();
            str.append("\nOrder number ");
            str.append(number);
            str.append(" (initial time - ");
            str.append(getInitialTime());
            str.append(", cooking time - ");
            str.append(getCookingTime());
            str.append(", served time - ");
            str.append(getInitialTime() + getCookingTime());
            str.append("):");
            return str.toString();
        }
        else {
            return null;
        }
    }

    public void writeToJson(String jsonPath) throws IOException {
        FileWriter file = new FileWriter(jsonPath, true);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        file.append(gson.toJson(dishes));
        file.flush();
    }

    public int getCookingTime() {
        int orderCookingTime = 0;
        int dishCookingTime;
        for (Dish dish: dishes) {
            dishCookingTime = dish.getCookingTime();
            if (dishCookingTime > orderCookingTime) {
                orderCookingTime = dishCookingTime;
            }
        }
        return orderCookingTime;
    }

}
