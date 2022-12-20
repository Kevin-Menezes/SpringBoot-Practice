package com.sbp.SpringBootPostgre;

import com.sbp.SpringBootPostgre.DAO.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPostgreApplication implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPostgreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// this.studentDao.createTable();

		this.studentDao.insertData("Keenan","Chennai");
	}
}
