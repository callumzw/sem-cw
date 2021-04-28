/*
 * The App program implements an application that
 * displays reports of Countries, Cities and Capitals.
 * These reports include population,name,continent,region etc.
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */
package com.napier.sem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

        @SpringBootApplication
        @RestController
        public class App {
            public static void main(String[] args) {

                if (args.length < 1) {
                    // Connect to database...
                    Connection.connect("localhost:33060");
                } else {
                    Connection.connect(args[0]);
                }
                SpringApplication.run(com.napier.sem.App.class, args);
            }
        }