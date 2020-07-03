package logic;

import order.Constraints;
import customer.Customer;
import order.Order;
import restaurant.dishes.Dish;
import restaurant.menu.Menu;

public class Logic {

    public static Order getOrder(Customer customer, Menu menu) {
        Order order = new Order();
        customer.getConstraints().getDishTypes().forEach((k, v) -> {
            Dish neededDish;
            for (int i = 0; i < v; i++) {
                neededDish = getNeededDish(customer.getConstraints(), k, menu);
                if (neededDish != null) {
                    order.addDish(neededDish);
                    spendCustomerResources(customer.getConstraints(), neededDish);
                }
            }
        });
        return order;
        /*if (order.getDishesAmount() > 0) {
            return order;
        }
        else {
            return null;
        }*/
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


