package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LanguageController
{
    /**
     * Get record of Continents total,urban and rural populations.
     * @return The record of Continent populations.
     */
    @RequestMapping("worldLanguage")
    public ArrayList<Language> worldLanguage(){
        return Language.worldLanguage();
    }

}
