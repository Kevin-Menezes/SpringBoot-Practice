package com.sbjdbc.SBJdbc;

import com.sbjdbc.SBJdbc.DAO.StudentDAO;
import com.sun.media.jfxmediaimpl.HostUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SbJdbcApplication implements CommandLineRunner {

	@Autowired
	private StudentDAO studentDAO;

	public static void main(String[] args) {
		SpringApplication.run(SbJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.studentDAO.createTable();
		this.insertStudent();
	}

	public void insertStudent() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter user name: ");
		String name = br.readLine();

		System.out.println("Enter user age: ");
		Integer age = Integer.parseInt(br.readLine());

		System.out.println("Enter user city: ");
		String city = br.readLine();

		this.studentDAO.insertData(name,age,city);
	}
}
