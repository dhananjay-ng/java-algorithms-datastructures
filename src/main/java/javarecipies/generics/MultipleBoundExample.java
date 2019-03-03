package javarecipies.generics;

import java.io.*;
import java.nio.CharBuffer;

/**
 * Created by apprentice on 7/16/2018.
 */
public class MultipleBoundExample {

    private static <S extends Readable & Closeable, D extends Appendable & Closeable>
    void copy(S source, D destination, int size)
            throws IOException {
        try {
            CharBuffer buffer = CharBuffer.allocate(size);
            source.read(buffer);
            buffer.flip();
            destination.append(buffer);
            buffer.clear();
            source.read(buffer);


        } finally {
            source.close();
            destination.close();
        }
    }

    public static void main(String[] args) {
        try {
            int size = 32;
            FileReader r = new FileReader("file.in");
            FileWriter w = new FileWriter("file.out");
            copy(r, w, size);
            BufferedReader br = new BufferedReader(new FileReader("file.in"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("file.out"));
            copy(br, bw, size);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
