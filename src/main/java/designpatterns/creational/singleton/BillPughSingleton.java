package designpatterns.creational.singleton;

public class BillPughSingleton {
    private static final long serialVersionUID = 1L;

    private BillPughSingleton() {
    }

    private static class LazyHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
