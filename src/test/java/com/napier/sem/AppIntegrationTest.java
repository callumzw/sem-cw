package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        Connection.connect("localhost:33060");
    }

    @Test
    void testGetEmployee()
    {
        ArrayList<Country> countries = Country.countriesWorld();
        assertEquals(countries.get(0).code, "CHN");
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(0).continent, "Asia");
    }
}
