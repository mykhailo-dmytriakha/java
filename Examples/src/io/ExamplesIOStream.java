package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class ExamplesIOStream {
    public static void main(String[] args) throws IOException {
        OutputStream dst = new FileOutputStream("d:/tmp.txt");
        dst = new BufferedOutputStream(dst, 8 * 1024);
        dst = new GZIPOutputStream(dst);
    }
}
