package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // Connecting to MySQL Database
        Connection.connect();
        /**
        // Get all Countries
        ArrayList<Country> countries = Country.countriesWorld();Country.displayCountry(countries);

        // Get al countries in a continent
        ArrayList<Country> countries = Country.countriesCont("Europe");
        Country.displayCountry(countries);
         **/

        // Get all countries in a region
        ArrayList<Country> countries = Country.countriesRegion("Central America");
        Country.displayCountry(countries);

         /**
        // Get all Cities
        ArrayList<City> cities = City.citiesWorld();
        City.displayCity(cities);

        // Get all Cities in a District
        ArrayList<City> cities = City.citiesDistrict("Zuid-Holland");
        City.displayCity(cities);

        // Get all Cities in a Region
        ArrayList<City> cities = City.citiesRegion("Caribbean");
        City.displayCity(cities);

        // Get all Cities in a Continent
        ArrayList<City> cities = City.citiesCont("Oceania");
        City.displayCity(cities);

        // Get all Cities in a Country
        ArrayList<City> cities = City.citiesCountry("Japan");
        City.displayCity(cities);


        // Get all Capitals in the world
         ArrayList<Capital> capitals = Capital.capitalsWorld();
         Capital.displayCapital(capitals);

        // Get all Capitals in a Continent
        ArrayList<Capital> capitals = Capital.capitalsCont("Europe");
        Capital.displayCapital(capitals);

        // Get all Capitals in a Region
        ArrayList<Capital> capitals = Capital.capitalsRegion("Southern Africa");
        Capital.displayCapital(capitals);
         **/


        // Disconnecting from MySQL Database
        Connection.disconnect();
    }
}
