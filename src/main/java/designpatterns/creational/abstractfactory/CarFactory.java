package designpatterns.creational.abstractfactory;

public class CarFactory {
    private CarFactory() {

    }

    public static Car buildCar(CarType carType) {
        Car car;
        Location location = Location.INDIA; // access location from some configuration.

        switch (location) {

            case INDIA:
                car =  IndianCarFactory.buildCar(carType);
                break;

            case USA:
                car =  USACarFactory.buildCar(carType);
                break;

            default:
                car =  DefaultCarFactory.buildCar(carType);
                break;
        }
        return car;
    }
}
