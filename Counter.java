/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

/**
 *
 * @author 2019-e-filinger
 */
public class Counter extends Thread{
    private static long couter = 0;
    
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        System.out.println("Starting");
        c.start();
        System.out.println("Waiting");
        c.join();
        System.out.println(couter);
    }

    @Override
    public void run() {
        for(int i = 0; i < 1_000_000_000; i++){
            couter++;
        }
    }
    
    
}
