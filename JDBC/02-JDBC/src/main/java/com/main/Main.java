package com.main;

import java.sql.*;

class Database{
    private Connection conn;

    public Database(String url,String username,String password){
        try {
            initDatabaseConnection(url,username,password);
            System.out.println("Connected to the Database Successfully");
        }
        catch(Exception e){
            System.err.println("There was an error while connecting to the database");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void closeConnection() throws SQLException {
        conn.close();
    }

    private void initDatabaseConnection(String url, String username, String password) throws Exception {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, username, password);
    }

    public void displayQuery(String query) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(query);
        ResultSetMetaData metaData = result.getMetaData();
        int columnCount = metaData.getColumnCount();

        for(int i=1; i<=columnCount; i++){
            System.out.print(metaData.getColumnLabel(i) + "\t");
        }
        System.out.println();

        while(result.next()){
            for(int i=1; i<= columnCount; i++){
                Object value = result.getObject(i);
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        result.close();
        st.close();
    }

    public ResultSet getRows(String query) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(query);
        st.close();
        return result;
    }

    public void executePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        int count = preparedStatement.executeUpdate();
        System.out.println(count + "row(s) affected");
    }

    public int insertValues(String query) throws SQLException {
       Statement st = conn.createStatement();
       int count = st.executeUpdate(query);
       System.out.println(count + " row(s) affected");
       st.close();
       return count;
    }

    public void showDatabases() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery("SELECT datname AS databases FROM pg_database WHERE datistemplate = false;");
        int columnCount = result.getMetaData().getColumnCount();
        System.out.println("SHOWING DATABASES");
        for(int i=1; i<=columnCount; i++){
            System.out.print(result.getMetaData().getColumnLabel(i) + "\t");
        }
        System.out.println();
        while(result.next()){
            for(int i=1; i<=columnCount; i++){
                System.out.print(result.getObject(i) + "\t");
            }
            System.out.println();
        }
        System.out.println("--- x --- x --- x ---");
    }

    public void showTables() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery("SELECT tablename AS non_system_tables FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema'");
        int columnCount = result.getMetaData().getColumnCount();
        System.out.println("SHOWING TABLES");
        for(int i=1; i<=columnCount; i++){
            System.out.print(result.getMetaData().getColumnLabel(i)+"\t");
        }
        System.out.println();
        while(result.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(result.getObject(i) + "\t");
            }
            System.out.println();
        }

        System.out.println("--- x --- x --- x ---");
    }


    public Connection getConnection() {
        return conn;
    }
}

/*
jdbc_practice_01.sql

CREATE TABLE student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    roll INT UNIQUE
);

*/

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/jdbc_practice_01";
        String username = "postgres";
        String password = "tirthraj07";
        Database db = new Database(url, username, password);
        db.showDatabases();
        db.showTables();
        db.displayQuery("SELECT * FROM students;");
        db.insertValues("INSERT INTO students (name, roll) VALUES ('Amey', 31237)");
        PreparedStatement preparedStatement = db.getConnection().prepareStatement("INSERT INTO students (name, roll) VALUES (?, ?)");
        preparedStatement.setString(1, "Aniket");
        preparedStatement.setInt(2, 31230);
        db.executePreparedStatement(preparedStatement);
        db.displayQuery("SELECT * FROM students;");
        db.closeConnection();
    }
}