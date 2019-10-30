package logic;

import customer.Customer;
import customer.CustomerWithMeal;
import restaurant.menu.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Customer customer = new Customer();
        Menu menu = new Menu();
        menu.readFromJson("C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\dishes\\menu.json");
        System.out.println(customer. convertToString());
        CustomerWithMeal customerWithMeal = Logic.getCustomerWithMeal(customer, menu);
        System.out.println(customerWithMeal.convertToString());
        customerWithMeal.writeToJson("C:\\Users\\Admin\\Desktop\\St\\Restaurant\\src\\restaurant\\dishes\\ordersReport.json");
    }
}
