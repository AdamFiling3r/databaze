/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author 2019-e-filinger
 */
public class ICO {

    static String nazev_firmy = "";
    public static void main(String args[]) {
        
        
        //vyvolavacVyjebanej(true);
        Scanner in = new Scanner(System.in);
        System.out.println("Zadejte IČO:");
        String ICO = in.nextLine();
        if(!Valid(ICO)){
            System.out.println("Neplatné IČO");
            System.exit(0);
        }else{
        URL url;
        try {
            // get URL content

            String a = "http://wwwinfo.mfcr.cz/cgi-bin/ares/darv_std.cgi?ico=" + ICO + "&xml=0";
            url = new URL(a);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                if (inputLine.contains("Obchodni_firma")) {
                    nazev_firmy = inputLine.substring(20, 35);
                }
            }
            br.close();

            System.out.println("Done");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    }

    public static String getNextWord(String str, String word) {
        String[] strArr = str.split(word);
        if (strArr.length > 1) {
            strArr = strArr[1].trim().split(" ");
            return strArr[0];
        }
        return null;
    }
    
    public static String getNazev(String nazev){
        return nazev_firmy;
    }
    
    public static void vyvolavacVyjebanej(boolean firstTime) {
        String ico = window(firstTime);
        boolean onlyNumbers = controller(ico);
        whatNext(onlyNumbers, ico);
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

    public static void whatNext (boolean onlyNumbers, String ico) {
        if (onlyNumbers) {
            
        } else {
            vyvolavacVyjebanej(false);
        }
    }

    public static boolean Valid(String ICO) {
        int vysledek = 0;
         int q = 0;
         
         
          for (int i = 0; i < (ICO.length() ); i++) {
            String cislo = Character.toString(ICO.charAt(i));
            int y = Integer.parseInt(cislo);

            if (i == 0) {
                vysledek = 8 * y;
            }
            if (i == 1) {
                vysledek += 7 * y;
            }
            if (i == 2) {
                vysledek += 6 * y;
            }
            if (i == 3) {
                vysledek += 5 * y;
            }
            if (i == 4) {
                vysledek += 4 * y;
            }
            if (i == 5) {
                vysledek += 3 * y;
            }
            if (i == 6) {
                vysledek += 2 * y;
            }
            if(i==7){
                q=y;
            }
            
        }
        vysledek = (11 - (vysledek % 11)) % 10;
        if (vysledek == q) {
            return true;
        }else{
            return false;
        }
         
    }
}
