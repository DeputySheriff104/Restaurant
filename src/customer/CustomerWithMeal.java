package customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import restaurant.dishes.Dish;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerWithMeal {

    private List<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    String convertToString() {
        StringBuilder str = new StringBuilder();
        if (dishes.size() != 0) {
            str.append("Customer has chosen:");
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
            str.append("\n");
        }
        else {
            str.append("\nCustomer has not chosen anything");
        }
        return str.toString();
    }

    void writeToJson(String jsonPath) throws IOException {
        FileWriter file = new FileWriter(jsonPath, true);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        file.append(gson.toJson(dishes));
        file.flush();
    }
}
