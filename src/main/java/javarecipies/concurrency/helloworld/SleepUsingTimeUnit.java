package javarecipies.concurrency.helloworld;

import java.util.concurrent.TimeUnit;

public class SleepUsingTimeUnit {
    public static void main(String[] args) throws InterruptedException {
        int val = 10;
        System.out.println("Sleeping for "+val+" ms");
        TimeUnit.SECONDS.sleep(val);

        System.out.println("Sleeping for "+val+" us");
        TimeUnit.MICROSECONDS.sleep(val);

        System.out.println("Sleeping for "+val+" ms");
        TimeUnit.MILLISECONDS.sleep(val);





    }
}
