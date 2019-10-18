package logic;

import customer.Customer;
import restaurant.menu.Menu;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws   FileNotFoundException {

        Customer customer = new Customer();
        Menu menu = new Menu();
        System.out.println(customer. convertToString());
        System.out.println(Logic.getCustomerWithMeal(customer, menu).convertToString());
        /*menu.readMenuFromTextFile(new File("Menu.txt"));*/

    }
}
