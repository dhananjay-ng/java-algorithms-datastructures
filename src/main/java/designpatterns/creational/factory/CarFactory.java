package designpatterns.creational.factory;

public class CarFactory {
    public static Car buildCar(CarType carType) {
        Car car;

        switch (carType) {

            case SMALL:
                car = new SmallCar();
                break;

            case SEDAN:
                car = new SedanCar();
                break;

            case LUXURY:
                car = new LuxuryCar();
                break;

            default:
                throw new RuntimeException();
        }
        return car;
    }
}
