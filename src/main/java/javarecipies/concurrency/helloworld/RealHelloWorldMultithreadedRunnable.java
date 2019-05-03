package javarecipies.concurrency.helloworld;

public class RealHelloWorldMultithreadedRunnable {
    public static class Greeter implements Runnable{
        private String country;

        public Greeter(String country) {
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
            new Thread(new Greeter(country),country + "thread").start();
        }

    }
}
