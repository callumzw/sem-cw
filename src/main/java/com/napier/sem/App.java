package com.napier.sem;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        // Connecting to MySQL Database
        Connection.connect();

        // Disconnecting from MySQL Database
        Connection.disconnect();
    }
}
