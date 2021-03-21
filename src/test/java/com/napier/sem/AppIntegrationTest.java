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
        assertEquals(countries.get(0).getCode(), "CHN");
        assertEquals(countries.get(0).getName(), "China");
        assertEquals(countries.get(0).getContinent(), "Asia");
    }
    @Test
    void testCountriesCont()
    {
        ArrayList<Country> countries = Country.countriesCont("Europe");
        assertEquals(countries.get(0).getCode(), "RUS");
        assertEquals(countries.get(0).getName(), "Russian Federation");
        assertEquals(countries.get(0).getRegion(), "Eastern Europe");
    }
    @Test
    void testCountriesRegion()
    {
        ArrayList<Country> countries = Country.countriesRegion("Central America");
        assertEquals(countries.get(0).getCode(), "MEX");
        assertEquals(countries.get(0).getName(), "Mexico");
        assertEquals(countries.get(0).getContinent(), "North America");
    }

    //City Class Tests
    @Test
    void testCitiesWorld()
    {
        ArrayList<City> cities = City.citiesWorld();
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(), "India");
        assertEquals(cities.get(0).getDistrict(), "Maharashtra");

    }

    @Test
    void testCitiesCont()
    {
        ArrayList<City> cities = City.citiesCont("Oceania");
        assertEquals(cities.get(0).getCountry(), "Sydney");
        assertEquals(cities.get(0).getCountry(), "Australia");
        assertEquals(cities.get(0).getDistrict(), "New South Wales");

    }
    @Test
    void testCitiesRegion()
    {
        ArrayList<City> cities = City.citiesRegion("Caribbean");
        assertEquals(cities.get(0).getName(), "La Habana");
        assertEquals(cities.get(0).getCountry(), "Cuba");
        assertEquals(cities.get(0).getDistrict(), "La Habana");

    }

    @Test
    void testCitiesCountry()
    {
        ArrayList<City> cities = City.citiesCountry("Japan");
        assertEquals(cities.get(0).getName(), "Tokyo");
        assertEquals(cities.get(0).getCountry(), "Japan");
        assertEquals(cities.get(0).getDistrict(), "Tokyo-to");

    }

    @Test
    void testCitiesDistrict()
    {
        ArrayList<City> cities = City.citiesDistrict("Zuid-Holland");
        assertEquals(cities.get(0).getName(), "Rotterdam");
        assertEquals(cities.get(0).getCountry(), "Netherlands");
        assertEquals(cities.get(0).getDistrict(), "Zuid-Holland");

    }
}
