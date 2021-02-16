package com.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.joda.time.DateTime;

@SpringBootApplication
public class MongoApp implements CommandLineRunner {

  @Autowired
  private TourRepos repository;

  public static void main(String[] args) {
    SpringApplication.run(MongoApp.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    // save a couple of customers
    repository.save(new Tour("Happy Moon", "Moon", new DateTime()));
    repository.save(new Tour("Mars Explorer", "Mars", new DateTime()));

    // fetch all customers
    System.out.println("Tours found with findAll():");
    System.out.println("-------------------------------");
    for (Tour tour : repository.findAll()) {
      System.out.println(tour);
    }
    System.out.println();

    // fetch an individual tour
    System.out.println("Customer found with findBytourName('Happy Moon'):");
    System.out.println("--------------------------------");
    System.out.println(repository.findBytourName("Happy Moon"));

    System.out.println("Customers found with findByDestination('Mars'):");
    System.out.println("--------------------------------");
    for (Tour tour : repository.findBydestAddress("Mars")) {
      System.out.println(tour);
    }

  }

}