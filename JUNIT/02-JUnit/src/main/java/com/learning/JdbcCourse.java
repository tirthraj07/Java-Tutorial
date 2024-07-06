package com.learning;

public class JdbcCourse implements Course{

    @Override
    public boolean coursePurchased() {
        System.out.println("JDBC Course Purchased");
        return true;
    }
}
