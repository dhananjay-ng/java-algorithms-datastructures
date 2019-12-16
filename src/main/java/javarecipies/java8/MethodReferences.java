package javarecipies.java8;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferences {

    public static void main(String[] args) {

        Function<Person, Integer> age = Person::getAge;
        Function<Person, Integer> height = Person::getHeight;

        Person person = new Person();
        person.setAge(23);
        person.setHeight(170);

        System.out.println(age.apply(person));
        System.out.println(height.apply(person));

        Consumer<String> printer = System.out::println;
        printer.accept("Hello World");


        Comparator<Person> allComparator =
                Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getLastName)
                .thenComparing(Person::getHeight);

    }


}
class Person implements Comparable{
    private int age;
    private  int height;
    private String firstName;
    private String lastName;
    private Person dad;

    public Person getDad() {
        return dad;
    }

    public void setDad(Person dad) {
        this.dad = dad;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
