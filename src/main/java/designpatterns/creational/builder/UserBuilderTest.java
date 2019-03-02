package designpatterns.creational.builder;

public class UserBuilderTest {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Dhananjay", "Nagargoje")
                .age(21)
                .phone("888877")
                .address("Mumbai")
                .build();

        System.out.println(user1);

    }
}
