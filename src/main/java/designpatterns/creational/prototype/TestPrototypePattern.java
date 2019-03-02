package designpatterns.creational.prototype;

public class TestPrototypePattern {
    public static void main(String[] args) {
        try {
            Movie moviePrototype = (Movie) PrototypeFactory.getInstance(PrototypeFactory.ModelType.MOVIE);
            System.out.println(moviePrototype);

            String albumPrototype = PrototypeFactory.getInstance(PrototypeFactory.ModelType.ALBUM).toString();
            System.out.println(albumPrototype);

            String showPrototype = PrototypeFactory.getInstance(PrototypeFactory.ModelType.SHOW).toString();
            System.out.println(showPrototype);

            Movie moviePrototype2 = (Movie) PrototypeFactory.getInstance(PrototypeFactory.ModelType.MOVIE);
            System.out.println(moviePrototype2);


            String albumPrototype2 = PrototypeFactory.getInstance(PrototypeFactory.ModelType.ALBUM).toString();
            System.out.println(albumPrototype);

            String showPrototype2 = PrototypeFactory.getInstance(PrototypeFactory.ModelType.SHOW).toString();
            System.out.println(showPrototype);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}