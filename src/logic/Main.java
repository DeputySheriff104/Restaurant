package logic;

import customer.CustomerThread;
import order.Order;
import restaurant.cooking.CookingThread;
import restaurant.menu.Menu;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        String menuPathJson = "C:\\Users\\Vlad\\IdeaProjects\\Restaurant\\sources\\json\\menu.json";
        String ordersReportPathJson = "C:\\Users\\Vlad\\IdeaProjects\\Restaurant\\sources\\json\\ordersReport.json";
        Menu menu = new Menu();
        menu.readFromJson(menuPathJson);
        int amountOfCustomers = 5;

        ArrayBlockingQueue<Order> ordersQueue = new ArrayBlockingQueue<>(10, true);

        CustomerThread customerThread = new CustomerThread(menu, ordersReportPathJson,2,
                amountOfCustomers);
        customerThread.startThread(ordersQueue);

        CookingThread cookingThread = new CookingThread(5, amountOfCustomers);
        cookingThread.startThread(cookingThread, ordersQueue);
    }
}
