package logic;

import customer.Constraints;
import customer.Customer;
import customer.CustomerWithMeal;
import restaurant.dishes.Dish;
import restaurant.menu.Menu;

class Logic {

    static CustomerWithMeal getCustomerWithMeal(Customer customer, Menu menu) {
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
        /*for (int i = 0; i < 3; i++) {
            int dishTypeAmount = customer.getConstraints().getDishTypes()[i];
            for (int j = 0; j < dishTypeAmount; j++) {
                neededDish = getNeededDish(customer.getConstraints(), i, menu);
                if (neededDish != null) {
                    customerWithMeal.addDish(neededDish);
                    spendCustomerResources(customer.getConstraints(), neededDish);
                }
            }
        }*/
        return customerWithMeal;
    }

    private static Dish getNeededDish(Constraints constraints, String dishType, Menu menu) {
        for (Dish dish: menu.getDishTypesMap().get(dishType)) {
            if (isDishSuitableForCustomer(constraints, dish)) {
                return dish;
            }
        }
        /*switch (dishType) { // НЕ НУЖНЫ КЕЙСЫ, ВСЕ ЧЕРЕЗ МАП
            ArrayList<Dish> dishes = menu.getDishTypesMap().get(dishType);
            case 0: {
                for (Dish mainCourse : dishes) {
                    if (isDishSuitableForCustomer(constraints, mainCourse)) {
                        return mainCourse;
                    }
                }
                break;
            }
            case 1: {
                for (Salad salad : menu.getSalads()) {
                    if (isDishSuitableForCustomer(constraints, salad)) {
                        return salad;
                    }
                }
                break;
            }
            case 2:
                for (Drink drink: menu.getDrinks()) {
                    if (isDishSuitableForCustomer(constraints, drink)) {
                        return drink;
                    }
                }
                break;
            }
        }*/
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


