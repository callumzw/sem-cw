package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class City
{

    /**
     * City name
     */
    public String name;

    /**
     * Country code
     */
    public String code;

    /**
     * City District
     */
    public String district;

    /**
     * City population
     */
    public int population;

    /**
     *  Methods
     */

    public static City getCity(int id)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Database.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE ID = " + id ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.name = rset.getString("Name");
                city.code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public static void displayCity(City city)
    {
        if (city != null)
        {
            System.out.println(
                    city.name + "\n"
                            + city.code + "\n"
                            + city.district + "\n"
                            + city.population + "\n");
        }
    }
}
