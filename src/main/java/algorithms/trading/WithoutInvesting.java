package algorithms.trading;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class WithoutInvesting {
    public static void main(String[] args) {
        //man has salary 50000 and saves 20000 (40% of salary )per month and can get annual increment of 10 %
        // so how much he can save in 30 years if he does not choose to invest.

        int sal = 50000;
        int save = (50000*40)/100;
        int inc = 10;

        int retirementAmount = 0;
        int investedRetirementAmount = 0;
        NumberFormat nf = DecimalFormat.getInstance();
        System.out.printf("%8s  %10s  %10s  %10s\n","Year","Income","Expense","Cash Retained");
        for (int i = 2; i <= 30; i++) {

            save*=12;
            retirementAmount += save;
            investedRetirementAmount += save;
            System.out.printf("%8d  %10s  %10s  %10s",
                    i,nf.format(sal*12),nf.format(sal*12-save),nf.format(retirementAmount));
            System.out.println();
         //   System.out.println("salary : " + sal);
         //   System.out.println("save   : " + save);
            sal = sal + ((sal*inc)/100);
            save = (sal*40)/100;

            //if he invests in some schemenwith 12 % return.
            investedRetirementAmount+=(investedRetirementAmount*12/100);


        }

        System.out.println();
        System.out.println("Man saves "+ DecimalFormat.getInstance().format( retirementAmount) + " if he does not invest anywhere.");
        System.out.println("Man saves "+ DecimalFormat.getInstance().format(investedRetirementAmount) + " if he  invests at 12 % per annum.");
    }
}
