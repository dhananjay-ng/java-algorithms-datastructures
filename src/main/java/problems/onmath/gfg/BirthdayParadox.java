package problems.onmath.gfg;

public class BirthdayParadox {
    /**
     * find the number of people need to be present in room such that probability of two persons
     * having same birthday is 50 %.
     */

    /**
     * P:
     * if there is one person in room then probability of him having different bday is 100%,
     * when one more person is added then probability of two person having different bday is descreased
     * as second person might have same bday as first one.
     * so P2 = 365/365*364/365
     * for 3 people P3 = p2 * 363/365 .. so on
     *
     * so when P get's less than 0.5 that means probability 2 peps having same bday is becomes 50%.
     */

    public static void main (String args[]) {
     float num = 365;
     float denom = 365;

     float p = 1;

     int numPeople = 0;

     while (p > 0.5) {
         p = p * (num/denom);
         num --;
         numPeople++;
         System.out.println("Probability of two people having different bday is "+ p);
     }

        System.out.println("So number people needed in room to have more than 50 % probability " +
                "of they having same bday is "+ numPeople);

    }
}
