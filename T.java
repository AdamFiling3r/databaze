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
public class T extends Thread{
    
    private int value;
    
    public int inc(){
        return value++;
    }
    public int dec(){
        return value--;
    }
    
    public int get(){
        return value;
    }
    
    public static void main(String[] args) throws InterruptedException {
        T t = new T(); 
        Thread add = new Thread(() -> {
        t.incNumber(1_000_000_000);
        });
        Thread sub = new Thread(() -> {
        t.subNumber(1_000_000_000);
        });
        add.start();
        sub.start();
        add.join();
        sub.join();
        System.out.println(t.value);
        
   }
    private synchronized void incNumber(int n){
//        value += n;
for(int i = 0; i < n; i++){
    inc();
}
    }
    private synchronized void subNumber(int n){
//        value -= n;
for(int i = 0; i < n; i++){
    dec();
}
    
    }
    
   
    
}
