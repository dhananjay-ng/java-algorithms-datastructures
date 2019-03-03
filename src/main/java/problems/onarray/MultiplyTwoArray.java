package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//To DO : Optimize it for space
public class MultiplyTwoArray {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        final int sign = (num1.get(0) < 0 ? -1 : 1 ) * (num2.get(0) < 0 ? -1 : 1);
        num1.set(0,Math.abs(num1.get(0)));
        num2.set(0,Math.abs(num2.get(0)));

        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int prodAi=0, carry=0,zeroFill=0;
        boolean nonZero=true;
        if ((num1.size()==1 && num1.get(0)==0)) {
            return num1;
        } else if((num2.size()==1 && num2.get(0)==0)) {
            return num2;
        }

        for (int i = num2.size() - 1; i >= 0; i--) {
            temp.clear();
            prodAi=0;
            carry=0;
            temp.addAll(Collections.nCopies(zeroFill,0));
            for (int j=num1.size()-1;j>=0;j--) {
                prodAi = num2.get(i) * num1.get(j) + carry;
                carry=0;
                if (prodAi > 9) {
                    carry=prodAi/10;
                    prodAi%=10;
                }
                temp.add(prodAi);
            }
            if (carry>0){
                temp.add(carry);
            }
            res=sumStep(res,temp);
            zeroFill++;
        }

        Collections.reverse(res);
        if (res.size()>0){
            res.set(0,sign*res.get(0));
        }
        return res;
    }

    private static List<Integer> sumStep(List<Integer> res, List<Integer> temp) {
        int sumAi=0,carry=0;
        if (res.size()==0) {
            res.addAll(temp);
        } else {
            for (int i = 0; (i < res.size() && i<temp.size()); i++) {
                sumAi = res.get(i) + temp.get(i) + carry;
                carry = 0;
                if (sumAi > 9) {
                    carry = 1;
                    sumAi %= 10;
                }
                res.set(i, sumAi);
            }
            if (res.size()>temp.size()) {
                for (int i= temp.size();i<res.size();i++){
                    sumAi = res.get(i) + carry;
                    carry = 0;
                    if (sumAi > 9) {
                        carry = 1;
                        sumAi %= 10;
                    }
                    res.set(i, sumAi);
                }

            }else if (res.size()<temp.size()){
                for (int i= res.size();i<temp.size();i++){
                    sumAi = temp.get(i) + carry;
                    carry = 0;
                    if (sumAi > 9) {
                        carry = 1;
                        sumAi %= 10;
                    }
                    res.add(sumAi);
                }

            }
            if (carry>0) {
                res.add(carry);
            }

        }
        return res;
    }
}
