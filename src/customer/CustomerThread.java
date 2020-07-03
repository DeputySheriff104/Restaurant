package customer;

import logic.Logic;
import order.Order;
import restaurant.menu.Menu;
import utilities.JsonUtility;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Math.floor;
import static java.lang.Thread.sleep;

public class CustomerThread {

    private Menu menu;
    private String ordersReportPathJson;
    private int customerSpawnTimeSeconds;
    private int amountOfCustomers;
    private int startTime;
    //ArrayBlockingQueue<Order> ordersQueue;

    public CustomerThread(Menu menu, String ordersReportPathJson, int customerSpawnTimeSeconds, int amountOfCustomers/*, ArrayBlockingQueue<Order> ordersQueue*/) {
        this.menu = menu;
        this.ordersReportPathJson = ordersReportPathJson;
        this.customerSpawnTimeSeconds = customerSpawnTimeSeconds;
        this.amountOfCustomers = amountOfCustomers;
        //this.ordersQueue = ordersQueue;
    }

    public void startThread(ArrayBlockingQueue<Order> ordersQueue) {
        Thread thread = new Thread(() -> {
            try {
                JsonUtility.addOpenSquareBracket(ordersReportPathJson);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int orderNumber = 1;
            startTime = (int) floor(System.nanoTime() / 1000000000.0);
            for (int i = 0; i < amountOfCustomers; i++) {
                Customer customer = new Customer();
                System.out.println(customer.convertToString());
                Order order = Logic.getOrder(customer, menu);
                order.setInitialTime((int) floor(System.nanoTime() / 1000000000.0) - startTime);
                if (order.getDishesAmount() != 0) {
                    order.setNumber(orderNumber++);
                }
                try {
                    ordersQueue.put(order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(order.convertToString());
                try {
                    sleep(customerSpawnTimeSeconds * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    order.writeToJson(ordersReportPathJson);
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
        if (amountOfCustomers == 0)
            thread.interrupt();
    }
}
