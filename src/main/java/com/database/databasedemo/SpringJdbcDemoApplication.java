package com.database.databasedemo;

import com.database.databasedemo.jdbc.PersonJdbcDao;
import com.database.databasedemo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

    private final PersonJdbcDao personJdbcDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SpringJdbcDemoApplication(PersonJdbcDao personJdbcDao) {
        this.personJdbcDao = personJdbcDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        personJdbcDao.findAll()
                .forEach(p -> logger.info("User {}", p));

        logger.info("User 1002: {}", personJdbcDao.findById(1002));
        logger.info("Deleting 1003 -> No of Rows Deleted -{}", personJdbcDao.deleteById(1003));

        Person person = new Person(1005,"Joe","Chicago", new Date());

        logger.info("Inserting user 1005: - > {}", personJdbcDao.insert(new Person(1005, "Joe", "Chicago", new Date())));

        logger.info("Update user 1004: - > {}", personJdbcDao.update(new Person(1004, "Adam", "Krakow", new Date())));
    }
}
