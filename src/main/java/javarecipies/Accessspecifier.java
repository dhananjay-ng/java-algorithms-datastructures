package javarecipies;

public class Accessspecifier {

    private Accessspecifier() {
        System.out.println("Hi");
    }
    public void hello() {
        Accessspecifier accessspecifier = new Accessspecifier();
    }

    public static void main(String[] args) {
        new Accessspecifier().hello();
    }
}
