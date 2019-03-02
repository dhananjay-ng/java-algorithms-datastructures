package designpatterns.creational.factory;

public abstract class Car {
    private CarType model;

    public Car(CarType carType) {
        this.model = carType;
        arrangeParts();

    }

    private void arrangeParts() {
        // common logic  here
    }

    //each car subclass will construct car in different way
    protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }


}
