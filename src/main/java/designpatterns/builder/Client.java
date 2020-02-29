package designpatterns.builder;

public class Client {
    public static void main(String[] args) {
        User.UserBuilder userBuilder = User.getBuilder();
        User user =
                userBuilder
                .withFname("Dhananjay")
                .withLname("Nagargoje")
                .withAge("23")
                .withSSC("88.89%")
                .withHSC("81.83%")
                .withGPA("8.13/10")
                .build();
        UserPrinter.printToCmd(user);

    }
}
