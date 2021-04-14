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
                    "SELECT Language, SUM((Percentage * (country.Population / 100)) / (SELECT SUM(DISTINCT country.Population)FROM country) * 100) AS worldPopulation "
                            + "FROM countrylanguage JOIN country ON countrylanguage.CountryCode=country.Code "
                            + "WHERE Language ='English' OR Language ='Chinese' OR Language ='Hindi' OR Language ='Spanish' OR Language ='Arabic' "
                            + " GROUP BY Language ORDER BY worldPopulation DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Language> languages = new ArrayList<Language>();
            // Check one is returned
            while (rset.next())
            {
                Language language = new Language();
                language.name = rset.getString("Language");
                language.population = rset.getLong("worldPopulation");
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
