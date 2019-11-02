package logic;

import customer.Constraints;
import customer.Customer;
import customer.CustomerWithMeal;
import restaurant.dishes.Dish;
import restaurant.menu.Menu;

public class Logic {

    public static CustomerWithMeal getCustomerWithMeal(Customer customer, Menu menu) {
        CustomerWithMeal customerWithMeal = new CustomerWithMeal();
        customer.getConstraints().getDishTypes().forEach((k, v) -> {
            Dish neededDish;
            for (int i = 0; i < v; i++) {
                neededDish = getNeededDish(customer.getConstraints(), k, menu);
                if (neededDish != null) {
                    customerWithMeal.addDish(neededDish);
                    spendCustomerResources(customer.getConstraints(), neededDish);
                }
            }
        });
        return customerWithMeal;
    }

    private static Dish getNeededDish(Constraints constraints, String dishType, Menu menu) {
        for (Dish dish: menu.getDishTypesMap().get(dishType)) {
            if (isDishSuitableForCustomer(constraints, dish)) {
                return dish;
            }
        }
        return null;
    }

    private static boolean isDishSuitableForCustomer(Constraints constraints, Dish dish) {
        return constraints.getMoney() >= dish.getPrice()
                && constraints.getTime() >= dish.getCookingTime()
                && constraints.getCalories() >= dish.getCalories();
    }

    private static void spendCustomerResources(Constraints constraints, Dish dish) {
        constraints.setMoney(constraints.getMoney() - dish.getPrice());
        constraints.setCalories(constraints.getCalories() - dish.getCalories());
    }
}


