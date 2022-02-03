/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2019-e-filinger
 */
public class ConTest {

    private static final String API = "jdbc";
    private static final String CONN = "mysql";
    private static final String HOST = "localhost";
    private static final String DATABASE = "dk-308_air";
    private static final String USER = "dk-308";
    private static final String PASSWORD = Secret.PASS;
    private static final String URL = API + ":" + CONN + "://" + HOST + "/" + DATABASE;

    public static void main(String[] args) throws SQLException {
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet res = stmt.executeQuery("SELECT * FROM airport")) {
                    while (res.next()) {
                        System.out.println(res.getString("name"));
                    }
                }
            }
        }

    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getURL() {
        return URL;
    }

    
    

}
