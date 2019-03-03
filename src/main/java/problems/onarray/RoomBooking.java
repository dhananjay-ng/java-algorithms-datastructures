package problems.onarray;

import java.util.ArrayList;
import java.util.Collections;

public class RoomBooking {
    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int max=0;
        for (int i=0;i<arrive.size();i++){
            if(arrive.get(i)>max)
                max=arrive.get(i);
        }
        for (int i=0;i<depart.size();i++){
            if(depart.get(i)>max)
                max=depart.get(i);
        }
        max+=1;

        int aa=0,jaa=0;
        for (int i=0;i<max;i++){
            while (aa<arrive.size()&&arrive.get(aa)==i ){
                K--;
                aa++;
            }
            while (jaa<depart.size()&&depart.get(jaa)==i ){
                K++;
                jaa++;
            }
            if (K<0){
                return false;
            }
        }

          return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> aa=new ArrayList<>();
        aa.add(1);
        aa.add(3);
        aa.add(4);

        ArrayList<Integer> bb=new ArrayList<>();
        bb.add(3);
        bb.add(4);
        bb.add(6);

        System.out.println(hotel(aa,bb,2));

    }

}
