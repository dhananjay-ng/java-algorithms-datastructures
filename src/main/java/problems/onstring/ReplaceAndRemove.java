package problems.onstring;

public class ReplaceAndRemove {

    //takes less than O(n^2)
    public static int replaceAndRemoveBruteForce(int size, char[] s) {
        int count = 0; int jump=-1;
        for (int i=0;i<s.length&&s[i]!='\u0000';i++){
            if (s[i]=='a'){
                jump=-1;
                s[i]='d';
                char temp=s[i+1];
                s[i+1]='d';
                int j=i+2;
                for ( ;j<s.length;j++){
                    if (temp=='b'||temp=='\u0000') break;
                    char next=s[j];
                    s[j]=temp;
                    temp=next;
                    if (s[j]=='a' && jump<0) jump=j;
                }
                if (jump<0) i=j-1;
                else i=jump-1;
            }
            if (s[i]=='b'){
                for (int j=i+1;j<s.length;j++){
                    if (s[j]=='a'){
                        s[j]='d';
                        s[j-1]='d';
                        break;
                    }
                    s[j-1]=s[j];
                    if (s[j]=='\u0000') break;

                }
                if (s[i]=='b') i--;
            }

        }
        while (count<s.length&&s[count]!='\u0000'){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[] aa = {'a', 'b', 'd', 'm', 'n', '\u0000', '\u0000'};
        int x=replaceAndRemoveBruteForce(5,aa);
        System.out.println(x);
        for (int i=0;i<x;i++){
            System.out.print(aa[i]+" ");
        }


    }
}
