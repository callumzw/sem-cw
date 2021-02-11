package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        // Create new Application
        App a = new App();

        // Connect to database
        Database.connect();

        //Get Angola
        Country country = Country.getCountry("AGO");
        //Display country info
        Country.displayCountry(country);

        //get Den Haag
        City city = City.getCity(7);
        City.displayCity(city);

        // Disconnect from database
        Database.disconnect();


    }

}
