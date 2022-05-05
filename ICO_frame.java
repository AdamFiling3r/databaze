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
import javax.swing.JOptionPane;

public class ICO_frame {
    
    
    public static void main(String[] args) {
        vyvolavacVyjebanej(true);
    }
    public static void vyvolavacVyjebanej(boolean firstTime) {
        String ico = window(firstTime);
        boolean onlyNumbers = controller(ico);
        whatNext(onlyNumbers);
    }

    public static String window(boolean firstTime) {
        String ico = "";
        if (firstTime) {
            ico = JOptionPane.showInputDialog(null, "What ICO you wanna find?", "ICO");
        } else {
            ico = JOptionPane.showInputDialog(null, "You're stupid", "ICO");
        }
        return ico;
    }

    public static boolean controller(String ico) {
        
        return ico.matches("[0-9]+");
    }

    public static void whatNext (boolean onlyNumbers) {
        if (onlyNumbers) {

        } else {
            vyvolavacVyjebanej(false);
        }
    }
}
