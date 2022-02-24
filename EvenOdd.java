/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2019-e-filinger
 */
public class EvenOdd {
    
    public static void main(String[] args) throws InterruptedException {
        EvenOdd eo = new EvenOdd();
        Thread even = new Thread(() -> eo.fillEven(10000));
        Thread od = new Thread(() -> eo.fillOdd(10000));
        even.start();
        od.start();
        even.join();
        od.join();
        System.out.println(eo.list);
        System.out.println(eo.list.size());
    }
    
    private final List<Integer> list = new ArrayList<>();
    
    public synchronized void  fillEven(int max){
        for(int i = 2; i <= max; i += 2){
            synchronized(this){
            int index = list.size();
            Math.sqrt(Math.random());
            list.add(index, i);
            }
        }
        
    }
    
    public synchronized void fillOdd(int max){
        for(int i = 1; i <= max; i += 2){
            synchronized(this){
            int index = list.size();
            Math.sqrt(Math.random());
            list.add(index, i);
            }
            
        }
        
    }
    
}
