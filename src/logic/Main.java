package logic;

import customer.Customer;
import customer.CustomerThread;
import customer.CustomerWithMeal;
import restaurant.menu.Menu;
import utilities.JsonUtility;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws IOException {

        String menuPathJson = "C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\jsonFiles\\menu.json";
        String ordersReportPathJson1 = "C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\jsonFiles\\ordersReport1.json";
        String ordersReportPathJson2 = "C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\jsonFiles\\ordersReport2.json";
        Menu menu = new Menu();
        menu.readFromJson(menuPathJson);

        CustomerThread customerThread1 = new CustomerThread(menu, ordersReportPathJson1, 2, 5);
        customerThread1.startThread();
        CustomerThread customerThread2 = new CustomerThread(menu, ordersReportPathJson2, 3, 4);
        customerThread2.startThread();

        /*Customer customer = new Customer();
        Menu menu = new Menu();
        menu.readFromJson("C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\dishes\\menu.json");
        System.out.println(customer. convertToString());
        CustomerWithMeal customerWithMeal = Logic.getCustomerWithMeal(customer, menu);
        System.out.println(customerWithMeal.convertToString());
        customerWithMeal.writeToJson("C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\dishes\\ordersReport1.json");*/
    }
}
