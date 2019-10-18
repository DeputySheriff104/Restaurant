package customer;

import restaurant.dishes.Dish;

import java.util.ArrayList;
import java.util.List;

public class CustomerWithMeal {

    private List<Dish> dishes = new ArrayList<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public String convertToString() {
        StringBuilder str = new StringBuilder();
        if (dishes.size() != 0) {
            str.append("\nCustomer has chosen:");
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
            str.append("\nCustomer has not chosen anything");
        }
        return str.toString();
    }
}
