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
public class SchoolLazy {
    
    private static SchoolLazy instance = null;

    public static SchoolLazy getInstance() {
        if(instance == null){
            instance = new SchoolLazy();
        }
        return instance;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private SchoolLazy() {
    }
    
    
    
    
}
