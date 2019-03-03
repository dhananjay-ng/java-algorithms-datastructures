package javarecipies.comparator;

/**
 * Created by apprentice on 7/13/2018.
 */
public class Fruit implements Comparable<Fruit> {
    private String name;
    private int size;

    public Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;

        Fruit fruit = (Fruit) o;

        return  size != fruit.size ? false:name.equals(fruit.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public int compareTo(Fruit fruit) {
        return this.equals(fruit)? 0 :this.name.compareTo(fruit.name)>0 ? 1:-1;
    }
}
