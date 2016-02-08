package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Objects;

/**
 * Created by mdmytiaha on 01-Dec-15.
 */
public class HttpExample {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(81);
        while (true) {
            Socket socket = serverSocket.accept();

            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                String result = readInputData(in);
                System.out.println(result);

                out.write(new Date().toString().getBytes());
            } finally {
                socket.close();
            }

        }
    }

    private static String readInputData(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();

        String newLine = System.getProperty("line.separator");
        String line;
        while (!Objects.equals(line = reader.readLine(), "")) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}
