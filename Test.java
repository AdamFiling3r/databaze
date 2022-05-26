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
public class Test {
    
    public static void main(String[] args) {
//        School.getInstance().setName("GA");
//        System.out.println(School.getInstance().getName());
//        MultitonLazy.getInstance("Hello").setName("hello");
//        MultitonLazy.getInstance("World").setName("world");
//        System.out.println(MultitonLazy.getInstance("Hello").getName());
//        System.out.println(MultitonLazy.getInstance("World").getName());
//        System.out.println(MultitonLazy.getInstance("Unknown").getName());
          SpeedTest st = new SpeedTest(1000);
          System.out.println(st.test(() -> {
              for(long i = 0; i < 100_000_000L; i++){
                  //...
              }
          }));
          System.out.println(st.test(() -> {
              for(long i = 0; i < 100_000_000L; ++i){
                  //...
              }
          }));
        
    }
    
}
