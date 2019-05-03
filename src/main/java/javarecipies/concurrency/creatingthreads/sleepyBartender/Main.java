package javarecipies.concurrency.creatingthreads.sleepyBartender;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args)
    {
        Bartender bartender = new Bartender();
        Thread bartenderThread = new Thread(bartender, "Bartender");

        bartenderThread.start();

        // Not very robust, but should allow the bartender to get to sleep first
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e)
        {
            // This can be ignored
        }

        int numCustomers = 5;

        for (int i=1; i<=numCustomers; i++) {
            String customerName = "Customer " + i;
            Customer customer = new Customer(bartenderThread, customerName, (int) (Math.random() * 10));

            new Thread(customer, customerName).start();
        }
    }
}
