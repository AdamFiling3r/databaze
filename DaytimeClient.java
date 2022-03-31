/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author 2019-e-filinger
 */
public class DaytimeClient extends Socket{
     private final Socket socket;
     private final BufferedReader input;
     private final BufferedWriter output;

     
     public static void main(String[] args) throws IOException {
        try(DaytimeClient dc = new DaytimeClient("vyuka.gyarab.cz", 7)){
            dc.write("hello");
            System.out.println(dc.read());
        }
    }
     
    public DaytimeClient(String name, int port) throws IOException {
        socket = new Socket(name, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    
    public String read() throws IOException{
        return input.readLine();
    }
    
    public void write(String str) throws IOException{
        output.write(str);
        output.newLine();
        output.flush();
    }
    
    
    @Override
    public void close() throws IOException{
        if(socket != null){
            socket.close();
        }
    }
     
     
    
    
}
