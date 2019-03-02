package designpatterns.creational.abstractfactory;

public class SmallCar extends Car {

    SmallCar(Location location) {
        super(CarType.SMALL, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car..");
        // add accessories
    }
}