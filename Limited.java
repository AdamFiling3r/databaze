/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2019-e-filinger
 */
public class Limited {
    
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);
        Thread consumer = new Thread(() -> {
            System.out.println("consumer is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Limited.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("consumer wokes up");
            while(!queue.isEmpty()){
                try {
                    System.out.println("consumed: " + queue.take());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Limited.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        consumer.start();
        add(queue, "hello");
        add(queue, "world");
        add(queue, "howdy");
        add(queue, "pg");
    }
    
    private static void add(BlockingQueue<String> queue, String s) throws InterruptedException{
        System.out.println("adding " + s);
        queue.put(s);
        System.out.println("added " + s);
    }
    
}
