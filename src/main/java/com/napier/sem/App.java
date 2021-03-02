package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // Connecting to MySQL Database
        Connection.connect();

        // Get all Countries
        ArrayList<Country> countries = Country.countriesWorld();
        System.out.println(countries.size());

        // Disconnecting from MySQL Database
        Connection.disconnect();
    }
}
