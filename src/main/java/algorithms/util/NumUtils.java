package algorithms.util;

public class NumUtils {
    public static int getNumOfDigits(int num ){
        int count=1;
        while(num/10>0){
            count++;
            num/=10;
        }
        return count;
    }

    public static boolean isAramstrong(String number){
        int armstrongSum=0;
        if(number!=null){
            try{
                for (int i=0;i<number.length();i++){
                     armstrongSum+= Math.pow(number.charAt(i)-48,3);
                }
            }catch (Exception e){
                return false;
            }
        }
        if (number.equals(String.valueOf(armstrongSum))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(NumUtils.isAramstrong("371"));
        System.out.println(NumUtils.isAramstrong("153"));
        System.out.println( NumUtils.isAramstrong("2"));
    }
}
