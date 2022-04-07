package lekce_309;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class EchoServer2 implements Closeable {

    private final ServerSocket server;
    private final List<EchoServer2Worker> workers = new ArrayList<>();

    public static void main(String[] args) {
        try (EchoServer2 ec = new EchoServer2(10000)) {
            ec.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EchoServer2(int port) throws IOException {
        System.out.println("create server socket");
        this.server = new ServerSocket(port);
        System.out.println("listening");
    }


    public void close() throws IOException {
        workers.forEach(worker -> {
            try {
                worker.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (server != null) {
            server.close();
        }
    }

    public void run() {
        while (true) {
            try {
                EchoServer2Worker worker = new EchoServer2Worker(server.accept());
                workers.add(worker);
                worker.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
