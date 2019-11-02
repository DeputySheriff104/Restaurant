package customer;

import logic.Logic;
import restaurant.menu.Menu;
import utilities.JsonUtility;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class CustomerThread {

    private Menu menu;
    private String ordersReportPathJson;
    private int customerSpawnTimeSeconds;
    private int amountOfCustomers;

    public CustomerThread(Menu menu, String ordersReportPathJson, int customerSpawnTimeSeconds, int amountOfCustomers) {
        this.menu = menu;
        this.ordersReportPathJson = ordersReportPathJson;
        this.customerSpawnTimeSeconds = customerSpawnTimeSeconds;
        this.amountOfCustomers = amountOfCustomers;
    }

    public void startThread() {
        Thread thread = new Thread(() -> {
            try {
                JsonUtility.addOpenSquareBracket(ordersReportPathJson);
            } catch (IOException e) {

                e.printStackTrace();
            }
            for (int i = 0; i < amountOfCustomers; i++) {
                try {
                    sleep(customerSpawnTimeSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Customer customer = new Customer();
                System.out.println(customer. convertToString());
                CustomerWithMeal customerWithMeal = Logic.getCustomerWithMeal(customer, menu);
                System.out.println(customerWithMeal.convertToString());
                try {
                    customerWithMeal.writeToJson(ordersReportPathJson);
                    if (i != amountOfCustomers-1) {
                        JsonUtility.addCommaAndNewLine(ordersReportPathJson);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                JsonUtility.addCloseSquareBracket(ordersReportPathJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
