package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The Language class creates objects containing information for a Language Report.
 * This is done through a SQL query in the world database, using the Connection Class
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-04-14
 */
public class Language {

    // Name of area.
    private String name;

    // Total population
    private long population;


    // Getters and Setters
    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public long getPopulation() {
        return population;
    }

    /**
     *  Methods
     */
    public static ArrayList<Language> worldLanguage()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Language, SUM(DISTINCT country.Population), SUM(city.Population), SUM(DISTINCT country.Population)-SUM(city.Population) "
                            + "FROM countryLanguage JOIN country ON countryLanguages.CountryCode=country.Code "
                            + "GROUP BY Continent ORDER BY SUM(country.Population) DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Language> languages = new ArrayList<Language>();
            // Check one is returned
            while (rset.next())
            {
                Language language = new Language();
                language.name = rset.getString("Continent");
                language.population = rset.getLong("SUM(DISTINCT country.Population)");
                languages.add(language);
            }
            return languages;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details");
            return null;
        }
    }
}
