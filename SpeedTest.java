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
public class SpeedTest {
    
    private final int count;

    public SpeedTest(int count) {
        this.count = count;
    }
    
    
    public long test(Runnable run){
        long start = System.nanoTime();
        for (int i = 0; i < count; i++){
            run.run();
        }
        long stop = System.nanoTime();
        return stop - start;
    }
    
}
