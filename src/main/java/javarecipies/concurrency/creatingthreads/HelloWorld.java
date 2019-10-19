package javarecipies.concurrency.creatingthreads;

import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static class Message implements Runnable {

        public String message;
        public Message(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
               while (true) {
                   if(Thread.interrupted()) {
                       System.out.println("i am interputted : "+Thread.currentThread().getId());
                       throw new InterruptedException();
                   }
               }

            } catch (InterruptedException e) {
            }
        }
    }
    public static void main(String args[]) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Message("Hello" + i));
            thread.start();
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();

        }
    }
}
