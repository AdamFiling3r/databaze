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
public abstract class FactoryShape {
    
    public static void main(String[] args) {
        FactoryShape fs = createRandomShape();
    }
    
    public static FactoryShape createCircle() {
        return new Circle();
    }
    
    public static FactoryShape createSquare() {
        return new Square();
    }
    
    public static FactoryShape createRandomShape(){
        return Math.random() > 0.5 ? createCircle() : createSquare();
    }
    
    private class Circle extends FactoryShape{
        
    @Override
    protected void _paint(){
        System.out.println("kruznice");
        
    }
    }
    
    protected abstract void _paint();
    public void paintShape(){
        //....
        _paint();
        //....
    }
        
    
}
