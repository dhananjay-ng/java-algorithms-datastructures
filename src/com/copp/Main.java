package com.copp;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt()
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong()
        {
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

        public double nextDouble()
        {
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

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read()
        {
            if (bufferPointer == bytesRead) {
                try {
                    fillBuffer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            byte c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append((char)c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }
        public void readIntArray(int a[],int n){
            for(int i=0;i<n;i++)
                a[i]=nextInt();

        }
        public void readLongArray(long a[],int n){
            for(int i=0;i<n;i++)
                a[i]=nextLong();
        }
        public void readStringArray(String a[],int n){
            for(int i=0;i<n;i++)
                a[i]=readString();
        }

        public boolean isSpaceChar(byte c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
    public static void main(String[] args) {
        // write your code here

        Reader in = new Reader();
        StringBuilder result = new StringBuilder();


        System.out.println(result);
    }
       /* int n=ir.readInt();`
        StringBuilder result=new StringBuilder();
        result.append(n).append("\n");
        System.out.println(result);
    */
}
