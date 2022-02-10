/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author 2019-e-filinger
 */
public class PrimeCounter extends Thread{
    
    
    private static final AtomicLong counter = new AtomicLong(0);
    public static void main(String[] args) {
//        for(long i = -1; i < 20; i++){
//            System.out.println(i + (isPrime(i) ? " je prvocislo" : " neni prvnocislo"));
//        }
//          System.out.println(countPrimes(0, 100));
            List<PrimeCounter> counters = new ArrayList<>();
            for(long i = 0; i < 10; i++){
                counters.add(new PrimeCounter(i * 1_000_000L, (i + 1) * 1_000_000L - 1));
            }
            counters.forEach(PrimeCounter::start);
            counters.forEach(c -> {
            try{
                c.join();
                
            }catch(InterruptedException ex){
                ex.printStackTrace(System.err);
            }
            });
    }
    
    public static boolean isPrime(long n){
        if(n < 2) return false;
        if(n == 2){
            return true;
        }
        if(n % 2 == 0){
            return false;
        }
//        long max = (long) Math.sqrt(n);
        for(long i = 3; i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static long countPrimes(long from, long to){
        long count = 0;
        for(long i = from; i <= to; i++){
            if(isPrime(i)){
                count++;
            }
        }
        
        return count;
    }
    
    private final long from;
    private final long to;

    public PrimeCounter(long from, long to) {
        this.from = from;
        this.to = to;
    }
    
    
    
    @Override
    public void run(){
        counter.addAndGet(countPrimes(from, to)); //count += countPrimes(from, to)
    }
    
    
}
