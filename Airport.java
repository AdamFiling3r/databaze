/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2019-e-filinger
 */
public class Airport {

    private final Connection con;

    public Airport(Connection con) {
        this.con = con;
    }

    public static void main(String[] args) throws SQLException {
        Airport air = new Airport(DriverManager.getConnection(ConTest.getURL(), ConTest.getUSER(), ConTest.getPASSWORD()));
        System.out.println(air.getAirportSize());
        System.out.println(air.getCountries());
        System.out.println(air.getAirportsByCountry("Antarctica"));

    }

    public int getAirportSize() throws SQLException {
        //SELECT COUNT(*) FROM airport
        try (Statement stmt = con.createStatement()) {
            try (ResultSet res = stmt.executeQuery("SELECT COUNT(*) FROM airport")) {
                if (res.next()) {
                    int count = res.getInt(1);
                    if (res.next()) {
                        throw new RuntimeException("too lines");
                    }
                    return count;
                } else {
                    throw new RuntimeException("empty result");
                }
            }
        }
    }

    public List<String> getCountries() throws SQLException {
        List countries = new ArrayList();
        try (Statement stmt = con.createStatement()) {
            try (ResultSet res = stmt.executeQuery("SELECT DISTINCT country FROM airport ORDER BY country")) {
                while (res.next()) {
                    countries.add(res.getString("country"));
                }
            }
        }
        return countries;
    }

    public List<String> getAirportsByCountry(String country) throws SQLException {
        List airportNames = new ArrayList();
//        try(Statement stmt = con.createStatement()){
//            try(ResultSet res = stmt.executeQuery(String.format("SELECT name FROM airport WHERE country = '%s'", country))){
//                while(res.next()){
//                    airportNames.add(res.getString("country"));
//                }
//            }
//        }

        try (PreparedStatement stmt = con.prepareStatement("SELECT name FROM airport WHERE country = ?")) {
            stmt.setString(1, country);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    airportNames.add(res.getString("name")); 
                }
            }
        }

        return airportNames;
    }

}
