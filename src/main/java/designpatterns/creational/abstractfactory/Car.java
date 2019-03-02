package designpatterns.creational.abstractfactory;


public abstract class Car {
    private CarType model;
    private Location location;

    public Car(CarType carType, Location location) {
        this.model = carType;
        this.location = location;

    }

    //each car subclass will construct car in different way
    protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Model- "+model + " built in "+location;
    }

}
