package com.database.databasedemo;

import com.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DatabaseDemoApplication(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        personJdbcDao.findAll()
                .forEach(p -> logger.info("User {}", p));

        logger.info("User 1002: {}", personJdbcDao.findById(1002));
    }
}
