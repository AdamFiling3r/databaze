/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 2019-e-filinger
 */
public class MultitonLazy {
    
    private static final Map<String, MultitonLazy> instances = new HashMap<String, MultitonLazy>();
    
    public static MultitonLazy getInstance(String key){
        if(!instances.containsKey(key)){
            instances.put(key, new MultitonLazy());
        }
        return instances.get(key);
    }
    
    static {
        getInstance("Unknown").setName("Unknown");
    }
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    private MultitonLazy(){
        
    }
    
}
