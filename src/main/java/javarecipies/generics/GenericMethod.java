package javarecipies.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    <T> void printType(T item) {

        System.out.println(item);

    }

    public static void main( String args[] ) {
        GenericMethod demo = new GenericMethod();
        demo.<String>printType("string");
        demo.<Integer>printType(5);
        demo.printType(23.23f);

        List<Employee> list = new ArrayList<>();
        save(list);

    }


    //upper bound on generics
    static void save(List<? extends Person> person) {

    }
}
class Person {

}
class Employee extends Person {

}