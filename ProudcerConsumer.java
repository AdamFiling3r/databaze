/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.Arrays;

/**
 *
 * @author 2019-e-filinger
 */
public class ProudcerConsumer {
    
    public static void main(String[] args) throws InterruptedException {
        ProudcerConsumer pc = new ProudcerConsumer();
        Thread producer = new Thread(() -> {
        for(int i = 1; i < 100; i++){
            pc.put(i);
        }
        
        });
        
        Thread consumer = new Thread(() -> {
        for(int i = 1; i < 100; i++){
            pc.get();
        }
        
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        
        String result = Arrays.toString(pc.data);
        System.out.println(result);
            }
    
    private final int[] data = new int[100];
    private int put = 0;
    private int get = data.length - 1;
    
    public void put(int value){
        while(put == get){
        //cekam na get
        }
        data[put] = value;
        put = (put + 1 ) % data.length;
    }
    
    public int get(){
        int newget = (get + 1) % data.length;
        while(newget == put){
            //cekam na put
        }
        
        get = newget;
        return data[get];
    }
    
}
