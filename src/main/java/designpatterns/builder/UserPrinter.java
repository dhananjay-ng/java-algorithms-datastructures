package designpatterns.builder;

import java.util.function.Consumer;

//Single Responsibility
public class UserPrinter {
    public static void printToCmd(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name : ").append(user.getFname())
                .append("\nLast Name  : ").append(user.getLname())
                .append("\nAge        : ").append(user.getAge())
                .append("\nSSC        : ").append(user.getSSC())
                .append("\nHSC        : ").append(user.getHSC())
                .append("\nGPA        : ").append(user.getGPA());

        System.out.println(sb.toString());
    }
}
