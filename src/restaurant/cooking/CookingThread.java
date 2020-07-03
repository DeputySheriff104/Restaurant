package restaurant.cooking;

import order.Order;

import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Thread.sleep;

public class CookingThread {

    private int amountOfCooks;
    //ArrayBlockingQueue<Order> ordersQueue;
    volatile int amountOfCustomers;


    public CookingThread(int amountOfFreeCooks, /*ArrayBlockingQueue<Order> ordersQueue,*/ int amountOfCustomers) {
        this.amountOfCooks = amountOfFreeCooks;
        //this.ordersQueue = ordersQueue;
        this.amountOfCustomers = amountOfCustomers;
    }

    public void startThread(CookingThread cookingThread, ArrayBlockingQueue<Order> ordersQueue) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < amountOfCooks; i++) {
                Cook cook = new Cook(ordersQueue, cookingThread);
            }
            while (amountOfCustomers > 0) {
                Thread.onSpinWait();
            }
            System.exit(0);
        });
        thread.start();
    }

    public int getAmountOfCustomers() {
        return amountOfCustomers;
    }

    public void setAmountOfCustomers(int amountOfCustomers) {
        this.amountOfCustomers = amountOfCustomers;
    }
}
