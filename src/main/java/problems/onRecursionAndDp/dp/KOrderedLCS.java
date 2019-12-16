package problems.onRecursionAndDp.dp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;

public class KOrderedLCS {
        private static InputStream stream;
        private static byte[] buf = new byte[1024];
        private static int curChar;
        private static int numChars;
        private static SpaceCharFilter filter;
        private static PrintWriter pw;
        private static long mod = 1000000000 + 7;
        private static void soln()
        {
            int n=nextInt();
            int m=nextInt();
            int k=nextInt();
            int[] arr1=nextIntArray(n);
            int[] arr2=nextIntArray(m);
            int[][] dp=new int[m+1][n+1];
            for(int i=0;i<=m;i++) {
                for(int j=0;j<=n;j++) {
                    if(i==0 || j==0) {
                        continue;
                    }else if(arr2[i-1]==arr1[j-1]) {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            int ans=dp[m][n];
            //for(int k1=0;k1<=k;k1++)
            //	ans=Math.max(ans, dp[m][n][k1]);
            pw.println(Math.min(ans+k,Math.min(m,n)));
        }
        private static boolean pos(int[] op,int[] arr,int n) {
            boolean f=true;
            for(int i=0;i<6;i++) {
                if(op[op[i]]!=i || op[i]==i)
                    f=false;
            }
            for(int i=1;i<n;i++) {
                if((op[arr[i-1]-1]==(arr[i]-1)) || (arr[i-1]==arr[i]))
                    f=false;
            }
            return f;
        }
        private static void dfs1(int cur, ArrayList<Integer>[] l) {
            pw.print((cur+1)+" ");
            for(int x:l[cur]) {
                if(x!=cur)
                    dfs1(x,l);
            }
        }
        private static void dfs(int cur, int prev, int[] max, LinkedList<Integer>[] tree, int[] val, int[] size, ArrayList<Integer>[] list) {
            max[cur]=val[cur];
            size[cur]=1;
            list[cur]=new ArrayList();
            list[cur].add(cur);
            Iterator<Integer> it=tree[cur].listIterator();
            while(it.hasNext()) {
                int x=it.next();
                if(x!=prev) {
                    dfs(x,cur,max,tree,val,size,list);
                    if(max[x]>=0) {
                        max[cur]+=max[x];
                        size[cur]+=size[x];
                        list[cur].add(x);
                    }
                }
            }
        }
        public static class Segment {
            private int[] base;
            private int[] tree;
            private int size;
            private int n;
            public Segment(int n,int[] arr){
                this.base=arr;
                int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
                size = 2 * (int) Math.pow(2, x) - 1;
                tree=new int[size];
                this.n=n;
                build(0,n-1,0);
                //System.out.println(query(0,n-1));
            }
            public void build(int l,int r,int id) {
                if(l==r) {
                    //System.out.println(l+" "+base[l]);
                    tree[id]=base[l];
                    return;
                }
                int mid=l+((r-l)>>1);
                build(l,mid,(id<<1)|1);
                build(mid+1,r,(id<<1)+2);
                tree[id]=Math.max(tree[(id<<1)|1],tree[(id<<1)+2]);
            }
            public int query(int l,int r){
                return queryUtil(l,r,0,0,n-1);
            }
            private int queryUtil(int x,int y,int id,int l,int r){
                if(l>y || x>r)
                    return 0;
                if(x <= l && r<=y)
                    return tree[id];
                int mid=l+((r-l)>>1);
                return Math.max(queryUtil(x,y,(id<<1)|1,l,mid),queryUtil(x,y,(id<<1)+2,mid+1,r));
            }
            public void update(int x,int colour,int id,int l,int r){
                //System.out.println(l+" "+r+" "+x);
                if(x>r || x<l)
                    return;
                if(l==r){
                    tree[id]=colour;
                    return;
                }
                int mid=l+((r-l)>>1);
                update(x,colour,(id<<1)|1,l,mid);
                update(x,colour,(id<<1)+2,mid+1,r);
                tree[id]=Math.max(tree[(id<<1)|1],tree[(id<<1)+2]);
            }
        }

        static void multiply(long[][] a, long[][] b, long m)
        {
            int n = a.length;
            long[][] mul = new long[n][n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    mul[i][j] = 0;
                    for (int k = 0; k < n; k++)
                        mul[i][j] = (mul[i][j] + (a[i][k] * b[k][j]) % m) % m;
                }
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = mul[i][j];
        }

        private static long pow(long a, long b, long c)
        {
            if (b == 0)
                return 1;
            long p = pow(a, b / 2, c);
            p = (p * p) % c;
            return (b % 2 == 0) ? p : (a * p) % c;
        }

        private static long gcd(long n, long l)
        {
            if (l == 0)
                return n;
            return gcd(l, n % l);
        }
        public static void main(String[] args) throws Exception
        {
//		new Thread(null, new Runnable()
//		{
//			@Override
//			public void run()
//			{
//				/*try {
//					InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\B-large-practice.in"));
//				} catch (FileNotFoundException e) { // TODO Auto-generated catch block
//					e.printStackTrace();
//				} */
//				InputReader(System.in);
//				pw = new PrintWriter(System.out);
//				/*try {
//					pw=new PrintWriter(new FileOutputStream("C:\\Users\\hardik\\Desktop\\out.txt"));
//				} catch (FileNotFoundException e) { // TODO Auto-generated catch block
//					e.printStackTrace();
//				}*/
//				soln();
//				pw.close();
//			}
//		}, "1", 1 << 26).start();

		/*try {
			InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\B-large-practice.in"));
		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} */
            InputReader(System.in);
            pw = new PrintWriter(System.out);
		/*try {
			pw=new PrintWriter(new FileOutputStream("C:\\Users\\hardik\\Desktop\\out.txt"));
		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}*/
            soln();
            pw.close();
        }

        public static void InputReader(InputStream stream1)
        {
            stream = stream1;
        }

        private static boolean isWhitespace(int c)
        {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private static boolean isEndOfLine(int c)
        {
            return c == '\n' || c == '\r' || c == -1;
        }

        private static int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                } catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        private static int nextInt()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private static long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private static String nextToken()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private static String nextLine()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        private static int[] nextIntArray(int n)
        {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = nextInt();
            }
            return arr;
        }

        private static long[] nextLongArray(int n)
        {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = nextLong();
            }
            return arr;
        }

        private static void pArray(int[] arr)
        {
            for (int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        private static void pArray(long[] arr)
        {
            for (int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        private static boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        private static char nextChar()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            char c1 = (char) c;
            while (!isSpaceChar(c))
                c = read();
            return c1;
        }

        private interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }

}
