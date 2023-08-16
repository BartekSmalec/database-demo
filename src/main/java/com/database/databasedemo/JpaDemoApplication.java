package com.database.databasedemo;

import com.database.databasedemo.jdbc.PersonJdbcDao;
import com.database.databasedemo.model.Person;
import com.database.databasedemo.repositories.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    private final PersonJpaRepository personJpaRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JpaDemoApplication(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {


        logger.info("User 1002: {}", personJpaRepository.findById(1002));

        logger.info("Inserting user 1005: - > {}", personJpaRepository.insert(new Person(1005, "Joe", "Chicago", new Date())));

        logger.info("Update user 1004: - > {}", personJpaRepository.update(new Person(1004, "Adam", "Krakow", new Date())));

        personJpaRepository.deleteById(1002);
        personJpaRepository.findAll()
                .forEach(p -> logger.info("User {}", p));
    }
}
