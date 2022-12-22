package com.sbjdbc.SBJdbc.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StudentDAO(){

    }

    // Create Table
    public void createTable(){

        String query = "CREATE TABLE IF NOT EXISTS student(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "age INT," +
                "city VARCHAR(100))";

        int create = this.jdbcTemplate.update(query);
        if (create==0){
            System.out.println("Table created");
        }
        else {
            System.out.println("Table not created");
        }
    }

    // Insert Data
    public void insertData(String name,Integer age,String city){

        String query = "INSERT INTO student(name,age,city) VALUES(?,?,?)";
        int insert = this.jdbcTemplate.update(query,new Object[]{name,age,city});

        if (insert==1){
            System.out.println("Data inserted");
        }
        else {
            System.out.println("Data not inserted");
        }

    }
}
