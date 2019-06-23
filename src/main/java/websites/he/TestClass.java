package websites.he;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestClass {
    public static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String readLine(int length) throws IOException {
            byte[] buf = new byte[length]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        public void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void ignore(int n) throws IOException {
            while (n-- > 0) read();
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.right = right;
            this.left = left;
        }

    }

    public static void main(String args[]) throws Exception {

        Reader in = new Reader("src\\main\\java\\websites\\he\\input.txt");
        StringBuilder result = new StringBuilder();
        int t = in.nextInt();
        int r = in.nextInt();
        in.readLine();
        TreeNode root = new TreeNode(r, null, null);
        for (int j = 0; j < t - 1; j += 1) {
            String path = in.readLine();
            int value = in.nextInt();
            in.readLine();
            TreeNode iter = root;
            int i = 0;
            for (; i < path.length() - 2; i++) {
                if (path.charAt(i) == 'L') {
                    iter = iter.left;
                } else {
                    iter = iter.right;
                }
            }
            if (path.charAt(i ) == 'L') {
                iter.left = new TreeNode(value, null, null);
            } else {
                iter.right = new TreeNode(value, null, null);
            }
        }
        TreeNode templ = root;
        result.append(diameter(root));
        System.out.println(result.toString());

    }

    public static int getHeight(TreeNode root) {
        if (root != null) {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
        return 0;
    }
    public static int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int diameter(TreeNode root) {
        if (root != null) {
            // get the left and right subtree height
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);

            // get the left diameter and right diameter recursively.
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);

            // get the max leftsubtree, rightsubtree, longest path goes through
            // root.
            return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
        }
        return 0;

    }

}

