package designpatterns.creational.abstractfactory;

public class LuxuryCar extends Car {

    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building Luxury Car ..");

    }
}
