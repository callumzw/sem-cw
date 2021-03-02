package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // Connecting to MySQL Database
        Connection.connect();
/**
        // Get all Countries
        ArrayList<Country> countries = Country.countriesWorld();
         Country.displayCountry(countries);

        // Get all Cities
        ArrayList<City> cities = City.citiesWorld();
        City.displayCity(cities);

        // Get all Cities in a District
        ArrayList<City> cities = City.citiesDistrict("Zuid-Holland");
        City.displayCity(cities);
**/
        // Get all Cities in a Region
        ArrayList<City> cities = City.citiesRegion("Caribbean");
        City.displayCity(cities);
/**
        // Get all Capitals
         ArrayList<Capital> capitals = Capital.capitalsWorld();
         Capital.displayCapital(capitals);
 **/


        // Disconnecting from MySQL Database
        Connection.disconnect();
    }
}
