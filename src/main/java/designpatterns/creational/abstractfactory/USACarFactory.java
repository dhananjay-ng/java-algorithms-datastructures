package designpatterns.creational.abstractfactory;

public class USACarFactory {
    public static Car buildCar(CarType carType)
    {
        Car car = null;
        switch (carType)
        {
            case SMALL:
                car = new SmallCar(Location.USA);
                break;

            case SEDAN:
                car = new SedanCar(Location.USA);
                break;

            case LUXURY:
                car = new LuxuryCar(Location.USA);
                break;

            default:
                //throw some exception
                break;
        }
        return car;
    }
}
