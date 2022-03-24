/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2019-e-filinger
 */
public class Worker extends Thread{
    
    private static BlockingQueue<Worker> workers = new LinkedBlockingQueue<>();
    
    
    public static void main(String[] args) {
        List<Runnable> jobs = new ArrayList<>();
        jobs.add(() -> System.out.println("Hello"));
        jobs.add(() -> System.out.println("Word"));
        jobs.add(() -> System.out.println(Math.random()));
        jobs.add(() -> {
        for(int i = 0; i < 100; i++){
            System.out.println(i);
        }
        });
    }

    
    @Override
    public void run(){
        try {
            workers.put(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
