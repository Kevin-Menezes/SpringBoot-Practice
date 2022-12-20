package com.sbp.SpringBootPostgre.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create Table
    public void createTable(){

        String query = "CREATE TABLE student (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "city VARCHAR(255))";

        int create = this.jdbcTemplate.update(query);
        if(create==0){
            System.out.println("Table created");
        }
        else{
            System.out.println("Error in table creation");
        }
    }

    // Insert Data
    public void insertData(String name, String city){

        // String query = "INSERT INTO student VALUES (1,"+name+","+city+")";
        String query = "INSERT INTO student (name,city) VALUES (?,?)";
        int insert = this.jdbcTemplate.update(query,name,city);

        if(insert==0){
            System.out.println("Data inserted");
        }
        else{
            System.out.println("Data Inserted");
        }
    }
}
