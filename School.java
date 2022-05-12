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
public class School {
    
    private static final School instance = new School();

    public static School getInstance() {
        return instance;
    }

    private String name;
    
    private School() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    
}
