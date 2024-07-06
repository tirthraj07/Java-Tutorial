package com.main;

import java.sql.*;


public class Main {
    public static void main(String[] args) {

        /*

            Step 2: Load and Register the driver

            NOTE

            Prior to Java 1.6, the driver had to be loaded by the application:
            either by calling Class.forName("org.postgresql.Driver"); or
            by passing the driver class name as a JVM parameter java -Djdbc.drivers=org.postgresql.Driver example.ImageViewer

            These older methods of loading the driver are still supported, but they are no longer necessary.

         */

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException exception){
            exception.printStackTrace();
        }

        /*
            Step 3: Create a connection

            In addition to the standard connection parameters the driver supports a number of additional properties which can be used to specify additional driver behaviour specific to PostgreSQL
            These properties may be specified in either the connection URL or an additional Properties object parameter to DriverManager.getConnection . The following examples illustrate the use of both methods to establish an SSL connection.

            Approach 1:
            String url = "jdbc:postgresql://localhost/test";
            Properties props = new Properties();
            props.setProperty("user", "fred");
            props.setProperty("password", "secret");
            props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);

            Approach 2:
            String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
            Connection conn = DriverManager.getConnection(url);

         */

        String url = "jdbc:postgresql://localhost:5432/jdbc_practice_01";
        String user = "postgres";
        String password = "tirthraj07";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database!");

                Statement s1 = conn.createStatement();
                String query = "SELECT * FROM students";
                ResultSet result = s1.executeQuery(query);

                while(result.next()){
                    String name = result.getString("name");
                    int roll = result.getInt("roll");
                    System.out.println(name + " : " + roll);
                }

            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}