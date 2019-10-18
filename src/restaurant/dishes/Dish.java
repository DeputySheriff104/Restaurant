package restaurant.dishes;

public abstract class Dish {

    private String name;
    private int price;
    private int cookingTime;
    private int calories;

    Dish(String name, int price, int cookingTime, int calories) {
        this.name = name;
        this.price = price;
        this.cookingTime = cookingTime;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getCalories() {
        return calories;
    }
}
