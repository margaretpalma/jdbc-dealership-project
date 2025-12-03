package com.pluralsight.dealership;


import org.apache.commons.dbcp2.BasicDataSource;

//database connection
//create and manage connections
public class DataSource {

    private static BasicDataSource ds = new BasicDataSource();

    //static - runs once

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/cardealership");
        ds.setUsername("root");
        ds.setPassword("yearup");
    }

    public static BasicDataSource getDataSource(){
        return ds;
    }

    }


