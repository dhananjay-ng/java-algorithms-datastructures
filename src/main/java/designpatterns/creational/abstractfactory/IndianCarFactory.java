package designpatterns.creational.abstractfactory;

public class IndianCarFactory {
    public static Car buildCar(CarType carType) {
        Car car = null;
        switch (carType) {
            case SMALL:
                car = new SmallCar(Location.INDIA);
                break;

            case SEDAN:
                car = new SedanCar(Location.INDIA);
                break;

            case LUXURY:
                car = new LuxuryCar(Location.INDIA);
                break;

            default:
                //throw some exception
                break;
        }
        return car;
    }
}
