package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
/**
 * The App program implements an application that
 * displays reports of Countries, Cities and Capitals.
 * These reports include population,name,continent,region etc.
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */
public class App {
    public static void main(String[] args) {

        // Connecting to MySQL Database
        if (args.length < 1)
        {
            // Connect to database...
            Connection.connect("localhost:33060");
        }
        else
        {
            Connection.connect(args[0]);
        }

        /*
        // Get all Countries
        ArrayList<Country> countries = Country.countriesWorld();
        Country.displayCountry((countries));

        // Get al countries in a continent
        countries = Country.countriesCont("Europe");
        Country.displayCountry(countries);


        // Get all countries in a region
        countries = Country.countriesRegion("Central America");
        Country.displayCountry(countries);


        // Get all Cities
        ArrayList<City> cities = City.citiesWorld();
        City.displayCity(cities);

        // Get all Cities in a Continent
        cities = City.citiesCont("Oceania");
        City.displayCity(cities);


        // Get all Cities in a Region
        cities = City.citiesRegion("Caribbean");
        City.displayCity(cities);


        // Get all Cities in a Country
        cities = City.citiesCountry("Japan");
        City.displayCity(cities);

        // Get all Cities in a District
        cities = City.citiesDistrict("Zuid-Holland");
        City.displayCity(cities);


        // Get all Capitals in the world
        ArrayList<Capital> capitals = Capital.capitalsWorld();
        Capital.displayCapital(capitals);

        // Get all Capitals in a Continent
        capitals = Capital.capitalsCont("Europe");
        Capital.displayCapital(capitals);

        // Get all Capitals in a Region
        capitals = Capital.capitalsRegion("Southern Africa");
        Capital.displayCapital(capitals);
        */
        // Get population of all continents
        ArrayList<Population> populations = Population.popContinent();
        Population.displayPopulation(populations);

        // Get population of all regions
        populations = Population.popRegion();
        Population.displayPopulation(populations);

        // Get population of all countries
        populations = Population.popCountry();
        Population.displayPopulation(populations);


        // Disconnecting from MySQL Database
        Connection.disconnect();
    }
}
