/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2019-e-filinger
 */
public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        Deadlock d = new Deadlock();
        Thread apple = new Thread(() -> {
        d.lockFirstLineAndDoSomething();
        
        });
        Thread banana = new Thread(() -> {
        d.doSomething();
        
        });
        apple.start();
        banana.start();
        Thread.sleep(1000);
    }
    
    private final Object hammer = new Object();
    private final Object pliers = new Object();
    private final List listAndLockSelf = new ArrayList();
    private final List<String[]> table = new ArrayList<>();

    public Deadlock() {
    
        table.add(new String[]{});
        
    }
    
    
    
    private void lockFirstLineAndDoSomething(){
        System.out.println("lockFirsLineAndDoSomething start " + Thread.currentThread().getId());
        synchronized(table.get(0)){
            System.out.println("lockFirsLineAndDoSomething got lock " + Thread.currentThread().getId());
            doSomething();
        }
        System.out.println("lockFirsLineAndDoSomething stop " + Thread.currentThread().getId());
        
    }
    
    private void doSomething(){
        System.out.println("doSomething start " + Thread.currentThread().getId());
        synchronized(table){
            System.out.println("lockFirsLineAndDoSomething got lock " + Thread.currentThread().getId());
            for(String[] line : table){
                System.out.println("doSomething start line " + Thread.currentThread().getId());
                synchronized(line){
                    
                }
            }
        }
        synchronized(listAndLockSelf){
        listAndLockSelf.add(hammer);
    }
        System.out.println("lockFirsLineAndDoSomething stop " + Thread.currentThread().getId());
        System.out.println("I can do anything");
    }    
    
    
}
