package customer;

import order.Constraints;

public class Customer {

    private Constraints constraints;

    public Customer() {
        constraints = new Constraints();
    }

    public String convertToString() {
        StringBuilder str = new StringBuilder();
        str.append("\nMoney: ");
        str.append(constraints.getMoney());
        str.append("\nTime: ");
        str.append(constraints.getTime());
        str.append("\nCalories: ");
        str.append(constraints.getCalories());
        str.append("\nDish amount: ");
        str.append(constraints.getDishAmount());
        str.append("\nDish types: ");
        constraints.getDishTypes().forEach((k, v) -> {
            str.append("\n");
            str.append(" - ");
            str.append(k);
            str.append(": ");
            str.append(v);
        });

        /*for (int i = 0; i < 3; i++) {
            int dishTypeAmount = constraints.getDishTypes()[i];
            if (dishTypeAmount != 0) {
                switch (i) {
                    case 0:
                        for (int j = 1; j <= dishTypeAmount; j++) {
                            str.append("\n - Main Course ");
                        }
                        break;
                    case 1:
                        for (int j = 1; j <= dishTypeAmount; j++) {
                            str.append("\n - Salad ");
                        }
                        break;
                    case 2:
                        for (int j = 1; j <= dishTypeAmount; j++) {
                            str.append("\n - Drink ");
                        }
                        break;
                }
            }*/
        return str.toString();
    }

    public Constraints getConstraints() {
        return constraints;
    }

}
