package restaurant.cooking;

import order.Order;

import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Thread.sleep;

public class Cook {

    boolean isFree = true;
    ArrayBlockingQueue<Order> ordersQueue;

    public Cook(ArrayBlockingQueue<Order> ordersQueue, CookingThread cookingThread) {
        this.ordersQueue = ordersQueue;
        startCookingOrders(ordersQueue, cookingThread);
    }

    public void startCookingOrders(ArrayBlockingQueue<Order> ordersQueue, CookingThread cookingThread) {
        Thread thread = new Thread(() -> {
            while (cookingThread.getAmountOfCustomers() > 0) {
/*                if (ordersQueue.peek() != null) {
                    //isFree = false;*/
                    //cookingThread.setAmountOfCustomers(cookingThread.getAmountOfCustomers() - 1);
                    Order order = ordersQueue.poll();
                    if (order != null) {
                        if (order.getDishesAmount() == 0) {
                            cookingThread.setAmountOfCustomers(cookingThread.getAmountOfCustomers() - 1);
                        }
                        else {
                            try {
                                sleep(order.getCookingTime() * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            order.setServeStatus(true);
                            cookingThread.setAmountOfCustomers(cookingThread.getAmountOfCustomers() - 1);
                            System.out.println(order.getStringOrderIsServedMessage());
                            //isFree = true;
                        }
                    }
            }
                /*}*/
        });
        thread.start();
        if (cookingThread.getAmountOfCustomers() == 0)
            thread.interrupt();
    }
}
