package datastructures.symboltables.hashtable;

import java.util.Date;

public class HashFunctions {
    public static int hashCodeString(String x) {
        int hash = 0;
        for (int i = 0; i < x.length(); i++) {
            hash = x.charAt(i) + hash * 31;
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(2).hashCode());
        System.out.println(hashCodeString("jsnfsjnsdjfnwi3i23njendjsd"));
        System.out.println(hashCodeString("zzzzzzzzzzzzzzzzzzzzz"));//goes negative
        System.out.println("zzzzzzzzzzzzzzzzzzzzz".hashCode());
        System.out.println(new Transaction("Dhanu",12.12,new Date()).hashCode());
        System.out.println(new Transaction("Dhanu",12.12,new Date()).hashCode());

        for (int i=0;i > -1111;i--){
           // System.out.print((i & 0x7fffffff) % 5);
            System.out.println(
                    i + " is -Ve Number  "
                    +Integer.toBinaryString((i))
                    + "  Making it Postive by masking with 31 one's "
                    +Integer.toBinaryString((i & 0x7fffffff))
                    +" hashing .. ("+i+" & 0x7fffffff) % 5 =  "
                    +(i & 0x7fffffff) % 5
            );

            //from java
            System.out.println(" using "+i+"&(5-1) "+(i  & (5-1)));
        }

    }


    static class Transaction {
        String who;
        Double howNumch;
        Date when;

        public Transaction(String how, Double howNumch, Date when) {
            this.who = how;
            this.howNumch = howNumch;
            this.when = when;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Transaction)) return false;

            Transaction that = (Transaction) o;

            if (who != null ? !who.equals(that.who) : that.who != null) return false;
            if (howNumch != null ? !howNumch.equals(that.howNumch) : that.howNumch != null) return false;
            return when != null ? when.equals(that.when) : that.when == null;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (howNumch != null ? howNumch.hashCode() : 0);
            result = 31 * result + (when != null ? when.hashCode() : 0);
            result = 31 * result + (who != null ? who.hashCode() : 0);
            return result;
        }
    }
}
