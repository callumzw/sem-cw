package com.napier.sem;

import org.junit.jupiter.api.AfterAll;
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

    @BeforeAll
    static void init()
    {
        Connection.connect("localhost:33060");
    }

    // Country tests
    @Test
    void testCountriesWorld()
    {
        ArrayList<Country> countries = Country.countriesWorld();
        assertEquals(countries.get(0).getCode(), "CHN");
        assertEquals(countries.get(0).getName(), "China");
        assertEquals(countries.get(0).getContinent(), "Asia");
        assertEquals(countries.get(0).getRegion(), "Eastern Asia");
        assertEquals(countries.get(0).getPopulation(), 1277558000 );
        assertEquals(countries.get(0).getCapital(), "Peking" );
    }
    @Test
    void testCountriesCont()
    {
        ArrayList<Country> countries = Country.countriesCont("Europe");
        assertEquals(countries.get(0).getCode(), "RUS");
        assertEquals(countries.get(0).getName(), "Russian Federation");
        assertEquals(countries.get(0).getContinent(), "Europe");
        assertEquals(countries.get(0).getRegion(), "Eastern Europe");
        assertEquals(countries.get(0).getPopulation(), 146934000 );
        assertEquals(countries.get(0).getCapital(), "Moscow" );
    }
    @Test
    void testCountriesRegion()
    {
        ArrayList<Country> countries = Country.countriesRegion("Central America");
        assertEquals(countries.get(0).getCode(), "MEX");
        assertEquals(countries.get(0).getName(), "Mexico");
        assertEquals(countries.get(0).getContinent(), "North America");
        assertEquals(countries.get(0).getRegion(), "Central America");
        assertEquals(countries.get(0).getPopulation(), 98881000);
        assertEquals(countries.get(0).getCapital(), "Ciudad de México" );

    }

    @Test
    void testTopCountriesCont()
    {
        ArrayList<Country> countries = Country.topCountryCont(1, "Europe");
        assertEquals(countries.get(0).getCode(), "RUS");
        assertEquals(countries.get(0).getName(), "Russian Federation");
        assertEquals(countries.get(0).getContinent(), "Europe");
        assertEquals(countries.get(0).getRegion(), "Eastern Europe");
        assertEquals(countries.get(0).getPopulation(), 146934000 );
        assertEquals(countries.get(0).getCapital(), "Moscow" );
    }



    //City Class Tests
    @Test
    void testCitiesWorld()
    {
        ArrayList<City> cities = City.citiesWorld();
        assertEquals(cities.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(cities.get(0).getCountry(), "India");
        assertEquals(cities.get(0).getDistrict(), "Maharashtra");
        assertEquals(cities.get(0).getPopulation(), 10500000);

    }

    @Test
    void testCitiesCont()
    {
        ArrayList<City> cities = City.citiesCont("Oceania");
        assertEquals(cities.get(0).getName(), "Sydney");
        assertEquals(cities.get(0).getCountry(), "Australia");
        assertEquals(cities.get(0).getDistrict(), "New South Wales");
        assertEquals(cities.get(0).getPopulation(), 3276207);

    }
    @Test
    void testCitiesRegion()
    {
        ArrayList<City> cities = City.citiesRegion("Caribbean");
        assertEquals(cities.get(0).getName(), "La Habana");
        assertEquals(cities.get(0).getCountry(), "Cuba");
        assertEquals(cities.get(0).getDistrict(), "La Habana");
        assertEquals(cities.get(0).getPopulation(), 2256000);

    }

    @Test
    void testCitiesCountry()
    {
        ArrayList<City> cities = City.citiesCountry("Japan");
        assertEquals(cities.get(0).getName(), "Tokyo");
        assertEquals(cities.get(0).getCountry(), "Japan");
        assertEquals(cities.get(0).getDistrict(), "Tokyo-to");
        assertEquals(cities.get(0).getPopulation(), 7980230);

    }

    @Test
    void testCitiesDistrict()
    {
        ArrayList<City> cities = City.citiesDistrict("Zuid-Holland");
        assertEquals(cities.get(0).getName(), "Rotterdam");
        assertEquals(cities.get(0).getCountry(), "Netherlands");
        assertEquals(cities.get(0).getDistrict(), "Zuid-Holland");
        assertEquals(cities.get(0).getPopulation(), 593321);

    }



    //Capitals Class Test
    @Test
    void testCapitalsWorld()
    {
        ArrayList<Capital> capitals = Capital.capitalsWorld();
        assertEquals(capitals.get(0).getName(), "Seoul");
        assertEquals(capitals.get(0).getCountry(), "South Korea");
        assertEquals(capitals.get(0).getPopulation(), 9981619);
    }

    @Test
    void testCapitalsCont()
    {
        ArrayList<Capital> capitals =  Capital.capitalsCont("Europe");
        assertEquals(capitals.get(0).getName(), "Moscow");
        assertEquals(capitals.get(0).getCountry(), "Russian Federation");
        assertEquals(capitals.get(0).getPopulation(), 8389200);
    }

    @Test
    void testCapitalsRegion()
    {
        ArrayList<Capital> capitals = Capital.capitalsRegion("Southern Africa");
        assertEquals(capitals.get(0).getName(), "Pretoria");
        assertEquals(capitals.get(0).getCountry(), "South Africa");
        assertEquals(capitals.get(0).getPopulation(), 658630);
    }



    //Population Class Test
    @Test
    void testPopulationContinent()
    {
        ArrayList<Population> populations = Population.popContinent();
        assertEquals(populations.get(0).getName(), "Asia");
        assertEquals(populations.get(0).getTotalPop(), "3705025700");
        assertEquals(populations.get(0).getCityPop(), "697604103(18%)");
        assertEquals(populations.get(0).getRuralPop(), "3007421597(81%)");
    }

    @Test
    void testPopulationRegion()
    {
        ArrayList<Population> populations = Population.popRegion();
        assertEquals(populations.get(0).getName(), "Eastern Asia");
        assertEquals(populations.get(0).getTotalPop(), "1507328000");
        assertEquals(populations.get(0).getCityPop(), "317476534(21%)");
        assertEquals(populations.get(0).getRuralPop(), "1189851466(78%)");
    }

    @Test
    void testPopulationCountry()
    {
        ArrayList<Population> populations = Population.popCountry();
        assertEquals(populations.get(0).getName(), "China");
        assertEquals(populations.get(0).getTotalPop(), "1277558000");
        assertEquals(populations.get(0).getCityPop(), "175953614(13%)");
        assertEquals(populations.get(0).getRuralPop(), "1101604386(86%)");
    }

    @Test
    void testRegionPopulation()
    {
        ArrayList<Population> populations = Population.regionPop("Western Europe");
        assertEquals(populations.get(0).getName(), "Western Europe");
        assertEquals(populations.get(0).getTotalPop(), "183247600");
        assertEquals(populations.get(0).getCityPop(), "45683298(24%)");
        assertEquals(populations.get(0).getRuralPop(), "137564302(75%)");
    }

    @Test
    void testCountryPopulation()
    {
        ArrayList<Population> populations = Population.countryPop("Mexico");
        assertEquals(populations.get(0).getName(), "Mexico");
        assertEquals(populations.get(0).getTotalPop(), "98881000");
        assertEquals(populations.get(0).getCityPop(), "59752521(60%)");
        assertEquals(populations.get(0).getRuralPop(), "39128479(39%)");
    }

    @Test
    void testDistrictPopulation()
    {
        ArrayList<Population> populations = Population.districtPop("Zuid-Holland");
        assertEquals(populations.get(0).getName(), "Zuid-Holland");
        assertEquals(populations.get(0).getTotalPop(), "1476710");
        assertEquals(populations.get(0).getCityPop(), "1476710(100%)");
        assertEquals(populations.get(0).getRuralPop(), "0 (0%)");
    }

    @Test
    void testCityPopulation()
    {
        ArrayList<Population> populations = Population.cityPop("Stockholm");
        assertEquals(populations.get(0).getName(), "Stockholm");
        assertEquals(populations.get(0).getTotalPop(), "750348");
        assertEquals(populations.get(0).getCityPop(), "750348(100%)");
        assertEquals(populations.get(0).getRuralPop(), "0 (0%)");
    }

  @Test
    void testWorldPop()
    {
        ArrayList<Population> populations = Population.worldPop();
        assertEquals(populations.get(0).getName(), "World");
        assertEquals(populations.get(0).getTotalPop(), "6078547450");
        assertEquals(populations.get(0).getCityPop(), "1429559884(23%)");
        assertEquals(populations.get(0).getRuralPop(), "4648987566(76%)");

    }

    @Test
    void testContinentPopulation()
    {
        ArrayList<Population> populations = Population.continentPop("Africa");
        assertEquals(populations.get(0).getName(), "Africa");
        assertEquals(populations.get(0).getTotalPop(), "784475000");
        assertEquals(populations.get(0).getCityPop(), "135838579(17%)");
        assertEquals(populations.get(0).getRuralPop(), "648636421(82%)");
    }


    @Test
    void testWorldLanguage() {
        ArrayList<Language> languages = Language.worldLanguage();
        assertEquals(languages.get(3).getName(), "English");
        assertEquals(languages.get(3).getPopulation(), "5%");

    }

    @AfterAll
    static void Disconnect ()
    {
        Connection.disconnect();
    }


}
