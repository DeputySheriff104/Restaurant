package order;

import java.util.HashMap;

public class Constraints {
    private int money;
    private int time;
    private int calories;
    private int dishAmount;
    private HashMap<String, Integer> dishTypes;

    public Constraints() {
        this.money = (int) (Math.random() * 40) + 10;
        this.time = (int) (Math.random() * 20) + 10;
        this.calories = (int) (Math.random() * 600) + 100;
        dishAmount = (int) (Math.random() * 3) + 1;
        dishTypes = new HashMap<>();
        for (int i = 0; i < dishAmount; i++) {
            switch ((int)(Math.random() * 3)) {
                case (0):
                    dishTypes.merge("Main Courses", 1, Integer::sum);
                    break;
                case (1):
                    dishTypes.merge("Salads", 1, Integer::sum);
                    break;
                case (2):
                    dishTypes.merge("Drinks", 1, Integer::sum);
                    break;
            }

        }
    }

    public int getMoney () {
        return money;
    }

    public int getTime () {
        return time;
    }

    public int getCalories () {
        return calories;
    }

    public void setMoney (int money){
        this.money = money;
    }

    public void setCalories (int calories){
        this.calories = calories;
    }

    public int getDishAmount() {
        return dishAmount;
    }

    public HashMap<String, Integer> getDishTypes() {
        return dishTypes;
    }
}
