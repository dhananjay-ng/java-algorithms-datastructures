package javarecipies.enums;

enum Season{
SPRING,WINTER,SUMMER,FALL

}
public class EnumUse {

    public static void main(String[] args) {
        System.out.println(Season.FALL.ordinal());
        System.out.println(Season.FALL.name());
    }

}
