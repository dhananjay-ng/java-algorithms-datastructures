package javarecipies.concurrency.creatingthreads.helloworld;

import java.util.concurrent.TimeUnit;

public class RealHelloWorldMultithreadedRunnable {
    public static class Greeter implements Runnable{
        private String country;

        public Greeter(String country) {
            this.country = country;
        }

        public void run(){
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long id = Thread.currentThread().getId();
            System.out.println("Hello "+country+ " Thread Id "+id);
        }
    }
    public static void main(String[] args) {
        String countries[] = { "India","France", "China", "USA", "Germany" };

        for (String country : countries){
            new Thread(new Greeter(country),country + "thread").start();
        }

    }

    public static class RealHelloWorldMultithreaded {
        public static class Greeter extends Thread{
            private String country;

            public Greeter(String country)
            {
                super(country + " thread"); // call the thread constructor to name the thread
                this.country = country;
            }

            public void run(){
                long id = Thread.currentThread().getId();
                System.out.println("Hello "+country+ " Thread Id "+id);
            }
        }
        public static void main(String[] args) {
            String countries[] = { "India","France", "China", "USA", "Germany" };

            for (String country : countries){
                new Greeter(country).start();
            }

        }
    }

    public static class RealHelloWorldMultithreadedCallRun
    {
        public static class Greeter extends Thread
        {
            private String country;

            public Greeter(String country)
            {
                super(country + " thread"); // call the thread constructor to name the thread
                this.country = country;
            }

            public void run()
            {
                System.out.println("Hello " + country + "!");
            }
        }

        public static void main(String[] args)
        {
            String countries[] = { "France", "India", "China", "USA", "Germany" };

            for (String country : countries)
            {
                new Greeter(country).run(); // Calls run() directly instead of start() (don't do this!)
            }
        }
    }

    public static class SleepUsingTimeUnit {
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
}
