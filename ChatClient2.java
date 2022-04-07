package lekce_309;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient2 implements Closeable {
    private final Socket socket;
    private final Scanner input;
    private final BufferedWriter output;
    private final Thread reader;

    public static void main(String[] args) {
        try (ChatClient2 ec = new ChatClient2("192.168.81.19", 10000)) {
            Scanner s = new Scanner(System.in);
            while (true) {
                String line = s.nextLine();
//                String line = "            AA          HHHHHH    HHHHHH        OOOOOOOO         JJJJJJ     !!!\n" +
//                        "           AAAA          HHHH      HHHH       OOOOOOOOOOOO        JJJJ     !!!!!\n" +
//                        "          AAAAAA         HHHH      HHHH      OOOO      OOOO       JJJJ     !!!!!\n" +
//                        "         AAAAAAA         HHHH      HHHH      OOOO      OOOO       JJJJ     !!!!!\n" +
//                        "         AAA AAAA        HHHHHHHHHHHHHH     OOOO        OOOO      JJJJ     !!!!!\n" +
//                        "        AAAA AAAAA       HHHHHHHHHHHHHH     OOOO        OOOO      JJJJ     !!!!!\n" +
//                        "       AAAA   AAAA       HHHHHHHHHHHHHH     OOOO        OOOO      JJJJ      !!! \n" +
//                        "       AAAAAAAAAAAA      HHHH      HHHH      OOOO      OOOO       JJJJ\n" +
//                        "      AAAA     AAAAA     HHHH      HHHH      OOOO      OOOO       JJJJ      !!!\n" +
//                        "     AAAAAA    AAAAAA    HHHH      HHHH       OOOOOOOOOOOO        JJJJ     !!!!!\n" +
//                        "    AAAAAAA    AAAAAAA  HHHHHH    HHHHHH        OOOOOOOO         JJJJ       !!!\n\n";
                if ("stop".equals(line)) break;
                ec.write(line);
            }
            System.out.println(ec.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ChatClient2(String name, int port) throws IOException {
        this.socket = new Socket(name, port);
        this.input = new Scanner(socket.getInputStream());
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        reader = new Thread(() -> {
            try {
                while (!socket.isClosed()) {
                    String line = read();
                    if (line == null) break;
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reader.start();
    }

    public String read() throws IOException {
        System.out.println("reading");
        return input.nextLine();
    }

    public void write(String line) throws IOException {
        System.out.println("writing");
        output.write(line);
        output.newLine();
        output.flush();
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
