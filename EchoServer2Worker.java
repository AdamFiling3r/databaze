package lekce_309;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer2Worker extends Thread implements Closeable {
//    private final ServerSocket server;
    private final Socket socket;
//    private final Scanner input;
    private final BufferedReader input;
    private final BufferedWriter output;

//    public static void main(String[] args) {
//        try (EchoServer2Worker ec = new EchoServer2Worker(10000)) {
//            while (true) {
//                System.out.println("waiting for a message");
//                String line = ec.read();
//                System.out.println("got: " + line);
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public EchoServer2Worker(Socket socket) throws IOException {
//        System.out.println("create server socket");
//        this.server = new ServerSocket(port);
//        System.out.println("listening");
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        this.input = new Scanner(socket.getInputStream());
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public String read() throws IOException {
        return input.readLine();
    }

    public void write(String line) throws IOException {
        output.write(line);
        output.newLine();
        output.flush();
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                System.out.println("Waiting for a message from " + socket);
                String line = read();
                System.out.println("Got a message from " + socket);
                if (line == null) {
                    break;
                }
                write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
