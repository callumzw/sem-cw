package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Capital {
    /**
     * City name
     */
    public String name;

    /**
     * City Country
     */
    public String country;

    /**
     * City population
     */
    public long population;


    /**
     * Methods
     */
    // All Capitals by Population in the World
    public static ArrayList<Capital> capitalsWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String capitalSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID "
                            + "ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(capitalSelect);
            // Return new employee if valid.
            ArrayList<Capital> capitals = new ArrayList<Capital>();
            // Check one is returned
            while (rset.next())
            {
                Capital capital = new Capital();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getLong("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // All Capitals by Population in x Continent
    public static ArrayList<Capital> capitalsCont(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String capitalSelect =
                    "SELECT city.Name, country.Name, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID AND country.Continent = '" +continent+ "' "
                            + "ORDER BY Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(capitalSelect);
            // Return new employee if valid.
            ArrayList<Capital> capitals = new ArrayList<Capital>();
            // Check one is returned
            while (rset.next())
            {
                Capital capital = new Capital();
                capital.name = rset.getString("city.Name");
                capital.country = rset.getString("country.Name");
                capital.population = rset.getLong("city.Population");
                capitals.add(capital);
            }
            return capitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Display Capitals
    public static void displayCapital(ArrayList<Capital> capitals)
    {
        System.out.println(String.format("%-17s %-17s %-14s", "Name", "Country", "Population"));
        for (Capital capital : capitals)
        {
            String capital_str =
                    String.format("%-17s %-17s %-14s",
                            capital.name, capital.country, capital.population);
            System.out.println(capital_str);
        }
        System.out.println("\n");
    }
}
