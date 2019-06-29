package websites.he.mergesort;
import java.util.*;
import java.math.*;
import java.io.*;
public class Beetles
{
    /**
     * It is a nice winter Sunday morning and AltF4, our hero, decides to play a new video game. The game is called Appearism. There are a total of N beetles in the game that are initially peeping out of the grooves to look for a chance to tease you.Each one appears out of their groves at an absolute time Pi, tease AltF4 for a time duration and then go back to their groves and sleep forever at time Qi.
     *
     * AltF4 has just got one shot of the nuclear weapon that ha can use to destroy all the beetles. Being very clever, he has noted down the (Pi, Qi) for each of the beetles. He also observed that the beetles are hurt by a amount A when they are looking for a chance to tease you in the groove (i.e. when time is < Pi), by B when they are out of their grooves teasing you (between Pi, Qi) and by C when they are back into the grooves and sleeping forever (when time is > Qi). Obviously B is always greater than both A and C. AltF4 being poor in math and computing asks you for favor.
     *
     * Input & Output
     *
     * The first line contains the number of times AltF4 plays the game T. Then the description of T games follow. In each game description, the first line contains four space separated integers N A B C. Then N lines follow with two space separated integers P Q, the recorded value of their hideouts. Each Q will always be ≥ corresponding P
     *
     * NOTE : Large Input files. Use faster IO.
     * For each test game, you are to print one number in a line, the maximum destruction that AltF4 can achieve. Remember that he may use the nuclear gun only at one instant of time.
     *
     * Constraints
     * T ≤ 50
     * 1 ≤ N ≤ 20000
     * 0 ≤ P, Q, A, B, C ≤ 109
     * SAMPLE INPUT
     * 2
     * 2 1 5 3
     * 3 4
     * 4 5
     * 3 1 5 3
     * 3 4
     * 5 5
     * 6 6
     * SAMPLE OUTPUT
     * 10
     * 11
     * @param args
     * @throws Exception
     */
    public static void main(String args[])throws Exception
    {
        Scanner in=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int t, i, j;
        t = in.nextInt();
        while(t-- > 0) {
            int N = in.nextInt();
            long A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
            int P[] = new int[N + 1], Q[] = new int[N + 1];

            for(i=0;i<N;i++) {
                P[i] = in.nextInt();
                Q[i] = in.nextInt();
            }
            P[N] = Q[N] = Integer.MAX_VALUE;
            Arrays.sort(P);
            Arrays.sort(Q);
            i = 0;j = 0;
            long current = N * A;
            long answer = current;
            while(i < N || j < N) {
                if(P[i] <= Q[j]) {
                    current += B - A;
                    i++;
                } else {
                    current += C - B;
                    j++;
                }
                answer = Math.max(answer, current);
            }
            out.println(answer);
        }
        out.flush();
    }
}
