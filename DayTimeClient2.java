package lekce_309;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.util.Scanner;

public class DayTimeClient2 implements Closeable {
    private final Socket socket;
    private final Scanner input;

    public static void main(String[] args) {
        try (DayTimeClient2 dc = new DayTimeClient2("vyuka.gyarab.cz", 13)) {
            System.out.println(dc.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DayTimeClient2(String name, int port) throws IOException {
        this.socket = new Socket(name, port);
        this.input = new Scanner(socket.getInputStream());
    }

    public String read() throws IOException {
        return input.nextLine();
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
