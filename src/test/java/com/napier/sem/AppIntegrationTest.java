package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * This class creates integration tests for the Country, City and Capital classes
 * Testing their methods interacting with the world SQL database.
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */
public class AppIntegrationTest
{
// Country Class Tests
    @BeforeAll
    static void init()
    {
        Connection.connect("localhost:33060");
    }

    @Test
    void testCountriesWorld()
    {
        ArrayList<Country> countries = Country.countriesWorld();
        assertEquals(countries.get(0).code, "CHN");
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(0).continent, "Asia");
    }
    @Test
    void testCountriesCont()
    {
        ArrayList<Country> countries = Country.countriesCont("Europe");
        assertEquals(countries.get(0).code, "RUS");
        assertEquals(countries.get(0).name, "Russian Federation");
        assertEquals(countries.get(0).region, "Eastern Europe");
    }
    @Test
    void testCountriesRegion()
    {
        ArrayList<Country> countries = Country.countriesRegion("Central America");
        assertEquals(countries.get(0).code, "MEX");
        assertEquals(countries.get(0).name, "Mexico");
        assertEquals(countries.get(0).continent, "North America");
    }

    //City Class Tests
    @Test
    void testCitiesWorld()
    {
        ArrayList<City> cities = City.citiesWorld();
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).country, "India");
        assertEquals(cities.get(0).district, "Maharashtra");

    }

    @Test
    void testCitiesCont()
    {
        ArrayList<City> cities = City.citiesCont("Oceania");
        assertEquals(cities.get(0).name, "Sydney");
        assertEquals(cities.get(0).country, "Australia");
        assertEquals(cities.get(0).district, "New South Wales");

    }
    @Test
    void testCitiesRegion()
    {
        ArrayList<City> cities = City.citiesRegion("Caribbean");
        assertEquals(cities.get(0).name, "La Habana");
        assertEquals(cities.get(0).country, "Cuba");
        assertEquals(cities.get(0).district, "La Habana");

    }

    @Test
    void testCitiesCountry()
    {
        ArrayList<City> cities = City.citiesCountry("Japan");
        assertEquals(cities.get(0).name, "Tokyo");
        assertEquals(cities.get(0).country, "Japan");
        assertEquals(cities.get(0).district, "Tokyo-to");

    }

    @Test
    void testCitiesDistrict()
    {
        ArrayList<City> cities = City.citiesDistrict("Zuid-Holland");
        assertEquals(cities.get(0).name, "Rotterdam");
        assertEquals(cities.get(0).country, "Netherlands");
        assertEquals(cities.get(0).district, "Zuid-Holland");

    }
}
